package anderk222.cine.dto;

public enum ResponseEnum {
    

        RESPONSE_OK("0001", "REALIZADO CON EXITO", "OK"),
        ERROR_LOGIN("9001", "ERROR AL INICIAR SESIÓN", null),
        NO_VERIFICATE("2001","NO SE HA VERIFICADO EN USUARIO", "NO SE HA REALIZADO LA VERIFICACIÓN DE LA CUENTA"),
        BAD_REQUEST("3001","VALORES INGRESADOS INCORRECTOS", "DATOS ENVIADOS NO CUMPLEN CON LAS ESPECIFICACIONES"),
        NOT_FOUND("4001", "NO ENCONTRADO", "EL RECURSO AL QUE DESEA ACCEDER NO EXIXTE"),
        INTERNAL_ERROR("8001", "ERROR", "OCURRIO UN ERROR INESPERADO"),
        ACCOUNT_BLOCKED("1001", "NUMERO DE INTENTOS ERRONEOS EXCEDIDOS", null),
        SESSIONS_EXCEDED("1002", "NUMERO DE SESSIONES ACTIVAS EXCEDIDO", null),
        NO_AUTHORIZED("9004", "NO TIENE AUTHORIZACION", null);
    
        public String codRespuesta;
        public String msgUsuario;
        public String msgTecnico;
    
        ResponseEnum(String codRespuesta, String msgUsuario, String msgTecnico) {
            this.codRespuesta = codRespuesta;
            this.msgUsuario = msgUsuario;
            this.msgTecnico = msgTecnico;
        }
}