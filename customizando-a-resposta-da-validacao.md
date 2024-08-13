# Customizando a resposta da validação

Para que possamos customizar as mensagens, criaremos uma classe chamada FieldMassage no pacote de dto.

```
public class FieldMessage {

    //name ou price
    private String fieldName;

    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
```

Só que são várias mensagens para serem exibidas. Com isso, precisamos criar uma Lista de FieldMessage.

Criaremos uma classe chamada ValidationError. Ela será uma sub-classe de CustomError. Ou seja, terá TUDO que o CustomError tem + a lista de erros, veja:

```
public class ValidationError extends CustomError {
    
    //lista de fieldmessage (classe acima)
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    //adicionando mensagens de erro a lista
    public void addError(String fieldname, String message) {
        errors.add(new FieldMessage(fieldname, message));
    }
}
```

O que acontece agora é o seguinte. Na nossa classe ControllerExceptionHandler, nós iremos alterar o método. (LEMBRE-SE, ESTE MÉTODO ALTERADO É PARA O RETORNO DO JSON)

Antes, nós instanciávamos o erro em um construtor CustomError, veja:

```
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        
        //instanciando o erro
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
```

Nós iremos retirar o CustomError e instanciar um ValidationError no seu lugar.

Além disso, para que possamos adicionar os erros na lista, iremos fazer o seguinte.

O método MethodArgumentNotValidException, possui dentro dele uma lista de erros.

Nós iremos percorrer essa lista e adicionar dentro da nossa FieldMessage, veja:

```
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    //a partir da instanciação da classe ValidationError, podemos adicionar
    //erros na lista
    ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados Inválidos", request.getRequestURI());


    //pegamos todos os erros da lista da nossa exceção
    //ele será chamado de "f"
    for (FieldError f : e.getBindingResult().getFieldErrors()) {
      err.addError(f.getField(), f.getDefaultMessage());
    }
    return ResponseEntity.status(status).body(err);
}
```

Ao fazer a requisição no Postman:

[![img\_10.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_10.png)](img\_10.png)
