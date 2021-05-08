package dto;

public class RequestAdminDto {
        private String tipDocument;
        private String date;
        private String residence;
        private String userName;
        private String idRequest;
        private String status;

        public String getTipDocument() {
            return tipDocument;
        }

        public void setTipDocument(String tipDocument) {
            this.tipDocument = tipDocument;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getResidence() {
            return residence;
        }

        public void setResidence(String residence) {
            this.residence = residence;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getIdRequest() {
            return idRequest;
        }

        public void setIdRequest(String idRequest) {
            this.idRequest = idRequest;
        }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
