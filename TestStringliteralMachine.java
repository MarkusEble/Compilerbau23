public class TestStringliteralMachine {

  public static void main(String[] args) throws Exception {
    System.out.println("HelloWorld");
    compiler.StateMachine StringliteralMachine = new compiler.machines.StringliteralMachine();
    java.io.OutputStreamWriter outWriter = new java.io.OutputStreamWriter(System.out);
    String Stringliteral = '"'+"!#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"+'"';
    char CharArr[] = Stringliteral.toCharArray();
    StringliteralMachine.process(String.copyValueOf(CharArr), outWriter);
  }
}
