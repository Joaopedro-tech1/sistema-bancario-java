package banco;

public class ContaBanco {
    public int idConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    public ContaBanco(int idConta, String dono, String tipo) {
        this.setIdConta(idConta);
        this.setDono(dono);
        this.setTipo(tipo);
        this.setSaldo(0);
        this.setStatus(false);
    }
    public void status() {
        System.out.println("ID da conta: " + this.getIdConta());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status da conta: " + (this.getStatus() ? "Aberta" : "Fechada"));
    }
    public void abrirConta() {
        this.setStatus(true);
        if (this.getTipo().equals("CC")) {
            this.setSaldo(50.0);
        } else if (this.getTipo().equals("CP")) {
            this.setSaldo(150.0);
        }
        System.out.println("Conta bancária aberta com sucesso para " + this.getDono());
    }
    
    public void fecharConta() {
        if (!this.status) {
            System.out.println("A conta ja está fechada.");
        } else if (this.saldo > 0) {
            System.out.println("Conta com dinheiro! Saque antes de fechar.");
        } else if (this.saldo < 0) {
            System.out.println("Conta em debito! Quite o saldo antes de fechar.");
        } else {
            this.status = false;
            System.out.println("Conta de " + this.dono + " fechada com sucesso.");
        }
    }
    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito de R$" + valor + " realizado com sucesso na conta de " + this.getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada.");
        }
    }
    
    public void sacar(double valor) {
        if (this.status) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado na conta de " + this.dono);
            } else {
                System.out.println("Saldo insuficiente para saque.");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada.");
        }
    }
    public void pagarMensalidade() {
        double valor = 0;
        if (this.tipo.equals("CC")) {
            valor = 12;
        } else if (this.tipo.equals("CP")) {
            valor = 20;
        }
        if (this.status) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.println("Mensalidade de R$ " + valor + " paga com sucesso por " + this.dono);
            } else {
                System.out.println("Saldo insuficiente para pagar a mensalidade.");
            }
        } else {
            System.out.println("Impossível pagar mensalidade de uma conta fechada.");
        }
    }
    
    public int getIdConta() {
        return this.idConta;
    }
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDono() {
        return this.dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "ContaBanco{" +
                "idConta=" + idConta +
                ", tipo='" + tipo + '\'' +
                ", dono='" + dono + '\'' +
                ", saldo=" + saldo +
                ", status=" + (status ? "Aberta" : "Fechada") +
                '}';
    }
}
