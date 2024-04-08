
public class ContaBanco {
//    Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

//    Metódos Personalizados
    public void estadoAtual(){
        System.out.println("--------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());


    }

    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true); //Método modificador
        if(t == "CC" ){ //Conta Corrente
          //  this.saldo = 50; - mexe direto no atributo
          this.setSaldo(50); // mexe direto no método
        } else if (t == "CP"){ //Conta Poupança
            this.setSaldo(150);
        }
        System.out.println("Conta Aberta Com Sucesso!");
    }
    public void fecharConta(){
        if (this.getSaldo() > 0){
            System.out.println("Conta não pode ser fechada porque ainda tem dinheiro ");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta não pode ser fechada pois tem débito "); //não entendi
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!! ");
        }
    }
    public void depositar(float v){
        if (this.getStatus() ){
//            this.saldo = this.saldo + v - mexe diretamente nos atributos
            this.setSaldo(this.getSaldo() + v); // mexe diretamente com métdos especiais
            System.out.println("Depósito realizado na conta de " + this.getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada");
        }
    }
    public void sacar(float v){
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque, não é possível sacar " + v);
            }
        } else {
            System.out.println("Impossivel Sacar de uma conta fechada");
        }
    }
    public void pagarMensal(){
        int v= 0;
        if(this.getTipo() == "CC") {
            v = 12;
        } else if (this.getTipo() == "CP"){
            v = 20;
        }
        if (this.getStatus()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        } else {
            System.out.println("Impossível pagar uma conta fechada");
        }
    }
//    Métodos Especiais - é um construtor usado para inicializar objetos

    public ContaBanco() {
        this.setSaldo(0);
        this.status = false;
    }
//O método get retorna o valor da variável e o método set define o valor.
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
