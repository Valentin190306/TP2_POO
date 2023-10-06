package ar.edu.unlu.poo.ej4512;

public class Usuario  {
        private static Integer indice = 10000;
        private Integer nroDeUsuario;
        private String nombre;
        private String DNI;
        private String email;
        private String telefono;

        public Usuario (String nombreDeUsuario, String DNI, String email, String telefono) {
                setNombre(nombreDeUsuario);
                setDNI(DNI);
                setEmail(email);
                setTelefono(telefono);
                setNroDeUsuario();
        }

        public Integer getNroDeUsuario() {
                return nroDeUsuario;
        }

        private void setNroDeUsuario () {
                this.nroDeUsuario = indice;
                indice++;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getDNI () {
                return DNI;
        }

        public void setDNI (String DNI) {
                this.DNI = DNI;
        }

        public String getEmail () {
                return email;
        }

        public void setEmail (String email) {
                this.email = email;
        }

        public String getTelefono () {
                return telefono;
        }

        public void setTelefono (String telefono) {
                this.telefono = telefono;
        }

        @Override
        public String toString () {
                return nroDeUsuario.toString() + " - " + nombre + " - " + DNI + " - " + telefono + " - " + email;
        }
}
