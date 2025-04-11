package banco;

public class ClienteEspecial extends ContaBanco {

    public ClienteEspecial(int idConta, String dono, String tipo) {
        super(idConta, dono, tipo);
    }

    @Override
    public void abrirConta() {
        this.setStatus(true);
        double bonus = 0;

        if (this.getTipo().equalsIgnoreCase("PLATINUM")) {
            bonus = 5000.0;
        } else if (this.getTipo().equalsIgnoreCase("GOLD")) {
            bonus = 3000.0;
        } else if (this.getTipo().equalsIgnoreCase("SILVER")) {
            bonus = 1000.0;
        } else if (this.getTipo().equalsIgnoreCase("CC")) {
            bonus = 100.0;
        } else if (this.getTipo().equalsIgnoreCase("CP")) {
            bonus = 150.0;
        }

        this.setSaldo(bonus);
        System.out.println("Conta especial " + tipo + " aberta para " + this.getDono() + "com bônus de R$" + String.format("%.2f", bonus));
    }
}
