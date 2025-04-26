public class validar extends Thread {
    private final String contraseña;

    public validar(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public void run() {
        boolean esValida = ValidaContra.validar(contraseña);
        String resultado = esValida ? "✅ VÁLIDA" : "❌ INVÁLIDA";
        System.out.println("🔐 Contraseña: " + contraseña + " --> " + resultado);
    }
}
