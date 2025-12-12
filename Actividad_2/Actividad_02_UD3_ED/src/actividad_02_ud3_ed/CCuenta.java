/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_02_ud3_ed;

/**
 * 
 * @author Daniel Copete
 */
public class CCuenta { /* Aqui se crea la clase ccuenta el lugar  donde inicializamos variables */


     
  protected String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInterés;

  
    public CCuenta ()
    {
    }
   /**
    * 
    * @param nom Nombre del titular de la cuenta
    * @param cue Variable en donde se guardad la cuenta
    * @param sal Variable en donde se guarda el saldo de la cuenta.
    * @param tipo Aqui es donde se guardan los  tipos de interes
    */
    public CCuenta (String nom, String cue, double sal, double tipo)
    {
        nombre =nom;
        cuenta=cue;
        saldo=sal;
        tipoInterés=tipo;
    }
  /**
   * 
   * @param nom Varable q se le asigan un nombre
   */
    public void asignarNombre(String nom)
    {
        nombre=nom;
    }
   
    public String obtenerNombre()
    {
        return nombre;
    }

    
     public double estado ()
    {
        return saldo;
    }

    
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0){
            throw new Exception("No se puede ingresar una cantidad negativa");}
        setSaldo(saldo + cantidad);
    }

   
    public void retirar (double cantidad) throws Exception
    {
        if (cantidad < 0){
            throw new Exception ("No se puede retirar una cantidad negativa");}
        if (estado()< cantidad){
            throw new Exception ("No se hay suficiente saldo");}
        setSaldo(saldo - cantidad);
    }
    
    public String obtenerCuenta ()
    {
        return cuenta;
    }

  
  public void setCuenta(String cuenta) {
    this.cuenta = cuenta;
  }

  
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

 
  public double getTipoInterés() {
    return tipoInterés;
  }

  
  public void setTipoInterés(double tipoInterés) {
    this.tipoInterés = tipoInterés;
  }
}
