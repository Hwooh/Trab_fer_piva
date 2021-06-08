/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRAB_INTER_FER;

import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pablo
 */
public class Trab{
    private List<String[]> dado = new ArrayList<>();
    private static long x = 0;
    private static long tempo1 = 0;
    private static long tempo2 = 0;
    private static long tempo3 = 0;
    private static int[] contagem = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    File f1 = new File("idatracacao.txt");
    File f2 = new File("cdtup.txt");
    File f3 = new File("berco.txt");
    File f4 = new File("portoatracacao.txt");
    File f5 = new File("ano.txt");
    File f6 = new File("mes.txt");
    File f7 = new File("tipooperacao.txt");
    File f8 = new File("tiponavegacaoatracacao.txt");
    File f9 = new File("terminal.txt");
    File f10 = new File("nacionalidadearmador.txt");
    File f11 = new File("tesperaatracacao.txt");
    File f12 = new File("tesperacainicioop.txt");
    File f13 = new File("toperacao.txt");
    File f14 = new File("tesperadesatracacao.txt");
    File f15 = new File("tatracado.txt");
    File f16 = new File("testadia.txt");
    File f17 = new File("idcarga.txt");
    File f18 = new File("origem.txt");
    File f19 = new File("destino.txt");
    File f20 = new File("cdmercadoria.txt");
    File f21 = new File("naturezacarga.txt");
    File f22 = new File("qtcarga.txt");
    File f23 = new File("pesocargabruta.txt");
    File f24 = new File("sentido.txt");
    File f25 = new File("cdmercadoria_cntr.txt");
    File f26 = new File("pesocarga_cntr.txt");
     
    public static void main(String... args) throws IOException, InterruptedException {     
        Info info = new Info();
        info.getProcessador();
        info.getDisco();
        info.getRAM(); 
        
        Trab obj = new Trab();
        obj.armazena();
        
        System.out.println("Tempo gasto pra a execução da etapa 1: " + tempo1/1000 + " segundos!");    
        System.out.println("Tempo gasto pra a execução da etapa 2: " + tempo2/1000 + " segundos!");
        System.out.println("Tempo gasto pra a execução da etapa 3: " + tempo3/1000 + " segundos!");
        
    }
    
     public void armazena() throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        String arquivoCSV = "C:\\Users\\pablo\\Desktop\\dataset_00_sem_virg.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        
        int i = 0, j = 0;
        try {
         
        br = new BufferedReader(new FileReader(arquivoCSV));
        long elapsed = System.currentTimeMillis() - start;
        tempo1 += elapsed;
        while ((linha = br.readLine()) != null) {
        long start2 = System.currentTimeMillis();
            String[] coluna = linha.split(csvDivisor);   
            if(j != 0 ){
            dado.add(coluna);
            }
            if(i == 1000000 || j == 14665111){
            long elapsed2 = System.currentTimeMillis() - start2;
            tempo1 += elapsed2;
            x = i;
               ProcessaThread pro = new ProcessaThread();
               Thread ThreadPro = new Thread((Runnable) pro);
               ThreadPro.start();
               long start3 = System.currentTimeMillis();
               i = 0;
               geraArq();
               ThreadPro.join();
               dado.clear();
               long elapsed3 = System.currentTimeMillis() - start3;
               tempo1 += elapsed3;
            }
            j += 1;
            i += 1;

        }
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       }

        long start1 = System.currentTimeMillis();
        FileWriter fw = new FileWriter(f1, true);
            BufferedWriter conexao = new BufferedWriter(fw);  
            conexao.write(Integer.toString(contagem[0]));
            conexao.newLine();
            conexao.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw1 = new FileWriter(f2, true);
            BufferedWriter conexao1 = new BufferedWriter(fw1);  
                conexao1.write(Integer.toString(contagem[1]));
                conexao1.newLine();
            conexao1.close();
            ////////////////////////////////////////////////////////////////
            FileWriter fw2 = new FileWriter(f3, true);
            BufferedWriter conexao2 = new BufferedWriter(fw2);  
                conexao2.write(Integer.toString(contagem[2]));
                conexao2.newLine();
            conexao2.close();

////////////////////////////////////////////////////////////////
            FileWriter fw3 = new FileWriter(f4, true);
            BufferedWriter conexao3 = new BufferedWriter(fw3);
                conexao3.write(Integer.toString(contagem[3]));
                conexao3.newLine();
            
            conexao3.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw4 = new FileWriter(f5, true);
            BufferedWriter conexao4 = new BufferedWriter(fw4);
  
                conexao4.write(Integer.toString(contagem[4]));
                conexao4.newLine();
            
            conexao4.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw5 = new FileWriter(f6, true);
            BufferedWriter conexao5 = new BufferedWriter(fw5);
   
                conexao5.write(Integer.toString(contagem[5]));
                conexao5.newLine();
            
            conexao5.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw6 = new FileWriter(f7, true);
            BufferedWriter conexao6 = new BufferedWriter(fw6);
  
                conexao6.write(Integer.toString(contagem[6]));
                conexao6.newLine();
            
            conexao6.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw7 = new FileWriter(f8, true);
            BufferedWriter conexao7 = new BufferedWriter(fw7);
                conexao7.write(Integer.toString(contagem[7]));
                conexao7.newLine();
            
            conexao7.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw8 = new FileWriter(f9, true);
            BufferedWriter conexao8 = new BufferedWriter(fw8);
                conexao8.write(Integer.toString(contagem[8]));
                conexao8.newLine();
            
            conexao8.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw9 = new FileWriter(f10, true);
            BufferedWriter conexao9 = new BufferedWriter(fw9); 
                conexao9.write(Integer.toString(contagem[9]));
                conexao9.newLine();
            
            conexao9.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw10 = new FileWriter(f11, true);
            BufferedWriter conexao10 = new BufferedWriter(fw10); 
                conexao10.write(Integer.toString(contagem[10]));
                conexao10.newLine();
            
            conexao10.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw11 = new FileWriter(f12, true);
            BufferedWriter conexao11 = new BufferedWriter(fw11);  
                conexao11.write(Integer.toString(contagem[11]));
                conexao11.newLine();
            
            conexao11.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw12 = new FileWriter(f13, true);
            BufferedWriter conexao12 = new BufferedWriter(fw12);
                conexao12.write(Integer.toString(contagem[12]));
                conexao12.newLine();
            
            conexao12.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw13 = new FileWriter(f14, true);
            BufferedWriter conexao13 = new BufferedWriter(fw13);
                conexao13.write(Integer.toString(contagem[13]));
                conexao13.newLine();
            
            conexao13.close();

           ////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
            FileWriter fw14 = new FileWriter(f15, true);
            BufferedWriter conexao14 = new BufferedWriter(fw14);
  
                conexao14.write(Integer.toString(contagem[14]));
                conexao14.newLine();
            
            conexao14.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw15 = new FileWriter(f16, true);
            BufferedWriter conexao15 = new BufferedWriter(fw15); 
                conexao15.write(Integer.toString(contagem[15]));
                conexao15.newLine();
            
            conexao15.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw16 = new FileWriter(f17, true);
            BufferedWriter conexao16 = new BufferedWriter(fw16);  
                conexao16.write(Integer.toString(contagem[16]));
                conexao16.newLine();
            
            conexao16.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw17 = new FileWriter(f18, true);
            BufferedWriter conexao17 = new BufferedWriter(fw17);
                conexao17.write(Integer.toString(contagem[17]));
                conexao17.newLine();
            
            conexao17.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw18 = new FileWriter(f19, true);
            BufferedWriter conexao18 = new BufferedWriter(fw18);
                conexao18.write(Integer.toString(contagem[18]));
                conexao18.newLine();
            
            conexao18.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw19 = new FileWriter(f20, true);
            BufferedWriter conexao19 = new BufferedWriter(fw19);  
                conexao19.write(Integer.toString(contagem[19]));
                conexao19.newLine();
            conexao19.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw20 = new FileWriter(f21, true);
            BufferedWriter conexao20 = new BufferedWriter(fw20);
                conexao20.write(Integer.toString(contagem[20]));
                conexao20.newLine();
            
            conexao20.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw21 = new FileWriter(f22, true);
            BufferedWriter conexao21 = new BufferedWriter(fw21);
                conexao21.write(Integer.toString(contagem[21]));
                conexao21.newLine();
            
            conexao21.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw22 = new FileWriter(f23, true);
            BufferedWriter conexao22 = new BufferedWriter(fw22);
                conexao22.write(Integer.toString(contagem[22]));
                conexao22.newLine();
            
            conexao22.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw23 = new FileWriter(f24, true);
            BufferedWriter conexao23 = new BufferedWriter(fw23);
                conexao23.write(Integer.toString(contagem[23]));
                conexao23.newLine();
            
            conexao23.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw24 = new FileWriter(f25, true);
            BufferedWriter conexao24 = new BufferedWriter(fw24);
                conexao24.write(Integer.toString(contagem[24]));
                conexao24.newLine();
            
            conexao24.close();
            
            ////////////////////////////////////////////////////////////////
            FileWriter fw25 = new FileWriter(f26, true);
            BufferedWriter conexao25 = new BufferedWriter(fw25);
                conexao25.write(Integer.toString(contagem[25]));
                conexao25.newLine();
            
            conexao25.close();
        long elapsed1 = System.currentTimeMillis() - start1;
        tempo3 += elapsed1;
    }
     
     
     
     
     
     
     
     
     
     
     
       public class ProcessaThread implements Runnable{      

        /**
         *
         */
        @Override
        public void run() {       
        long start = System.currentTimeMillis();
        for(int i = 0; i < x; i++){
            for(int j = 0; j < 26; j++){    
                boolean integerOrNot = dado.get(i)[j].matches("-?\\d+");
                if (!integerOrNot){
                   contagem[j] += 1;
                }
            }
        }
        long elapsed = System.currentTimeMillis() - start;
        tempo2 += elapsed;
        
        }
        }      
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       public void geraArq() throws IOException{
           long start = System.currentTimeMillis();
           ////////////////////////////////////////////////////////////////
                    
            FileWriter fw = new FileWriter(f1, true);
            BufferedWriter conexao = new BufferedWriter(fw);
            for(int i = 0; i < x; i++){   
                conexao.write(dado.get(i)[0]);
                conexao.newLine();
            }
            conexao.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw1 = new FileWriter(f2, true);
            BufferedWriter conexao1 = new BufferedWriter(fw1);
            for(int i = 0; i < x; i++){   
                conexao1.write(dado.get(i)[1]);
                conexao1.newLine();
            }
            conexao1.close();
            ////////////////////////////////////////////////////////////////
            FileWriter fw2 = new FileWriter(f3, true);
            BufferedWriter conexao2 = new BufferedWriter(fw2);
            for(int i = 0; i < x; i++){   
                conexao2.write(dado.get(i)[2]);
                conexao2.newLine();
            }
            conexao2.close();

////////////////////////////////////////////////////////////////
            FileWriter fw3 = new FileWriter(f4, true);
            BufferedWriter conexao3 = new BufferedWriter(fw3);
            for(int i = 0; i < x; i++){   
                conexao3.write(dado.get(i)[3]);
                conexao3.newLine();
            }
            conexao3.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw4 = new FileWriter(f5, true);
            BufferedWriter conexao4 = new BufferedWriter(fw4);
            for(int i = 0; i < x; i++){   
                conexao4.write(dado.get(i)[4]);
                conexao4.newLine();
            }
            conexao4.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw5 = new FileWriter(f6, true);
            BufferedWriter conexao5 = new BufferedWriter(fw5);
            for(int i = 0; i < x; i++){   
                conexao5.write(dado.get(i)[5]);
                conexao5.newLine();
            }
            conexao5.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw6 = new FileWriter(f7, true);
            BufferedWriter conexao6 = new BufferedWriter(fw6);
            for(int i = 0; i < x; i++){   
                conexao6.write(dado.get(i)[6]);
                conexao6.newLine();
            }
            conexao6.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw7 = new FileWriter(f8, true);
            BufferedWriter conexao7 = new BufferedWriter(fw7);
            for(int i = 0; i < x; i++){   
                conexao7.write(dado.get(i)[7]);
                conexao7.newLine();
            }
            conexao7.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw8 = new FileWriter(f9, true);
            BufferedWriter conexao8 = new BufferedWriter(fw8);
            for(int i = 0; i < x; i++){   
                conexao8.write(dado.get(i)[8]);
                conexao8.newLine();
            }
            conexao8.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw9 = new FileWriter(f10, true);
            BufferedWriter conexao9 = new BufferedWriter(fw9);
            for(int i = 0; i < x; i++){   
                conexao9.write(dado.get(i)[9]);
                conexao9.newLine();
            }
            conexao9.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw10 = new FileWriter(f11, true);
            BufferedWriter conexao10 = new BufferedWriter(fw10);
            for(int i = 0; i < x; i++){   
                conexao10.write(dado.get(i)[10]);
                conexao10.newLine();
            }
            conexao10.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw11 = new FileWriter(f12, true);
            BufferedWriter conexao11 = new BufferedWriter(fw11);
            for(int i = 0; i < x; i++){   
                conexao11.write(dado.get(i)[11]);
                conexao11.newLine();
            }
            conexao11.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw12 = new FileWriter(f13, true);
            BufferedWriter conexao12 = new BufferedWriter(fw12);
            for(int i = 0; i < x; i++){   
                conexao12.write(dado.get(i)[12]);
                conexao12.newLine();
            }
            conexao12.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw13 = new FileWriter(f14, true);
            BufferedWriter conexao13 = new BufferedWriter(fw13);
            for(int i = 0; i < x; i++){   
                conexao13.write(dado.get(i)[13]);
                conexao13.newLine();
            }
            conexao13.close();

           ////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
            FileWriter fw14 = new FileWriter(f15, true);
            BufferedWriter conexao14 = new BufferedWriter(fw14);
            for(int i = 0; i < x; i++){   
                conexao14.write(dado.get(i)[14]);
                conexao14.newLine();
            }
            conexao14.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw15 = new FileWriter(f16, true);
            BufferedWriter conexao15 = new BufferedWriter(fw15);
            for(int i = 0; i < x; i++){   
                conexao15.write(dado.get(i)[15]);
                conexao15.newLine();
            }
            conexao15.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw16 = new FileWriter(f17, true);
            BufferedWriter conexao16 = new BufferedWriter(fw16);
            for(int i = 0; i < x; i++){   
                conexao16.write(dado.get(i)[16]);
                conexao16.newLine();
            }
            conexao16.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw17 = new FileWriter(f18, true);
            BufferedWriter conexao17 = new BufferedWriter(fw17);
            for(int i = 0; i < x; i++){   
                conexao17.write(dado.get(i)[17]);
                conexao17.newLine();
            }
            conexao17.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw18 = new FileWriter(f19, true);
            BufferedWriter conexao18 = new BufferedWriter(fw18);
            for(int i = 0; i < x; i++){   
                conexao18.write(dado.get(i)[18]);
                conexao18.newLine();
            }
            conexao18.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw19 = new FileWriter(f20, true);
            BufferedWriter conexao19 = new BufferedWriter(fw19);
            for(int i = 0; i < x; i++){   
                conexao19.write(dado.get(i)[19]);
                conexao19.newLine();
            }
            conexao19.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw20 = new FileWriter(f21, true);
            BufferedWriter conexao20 = new BufferedWriter(fw20);
            for(int i = 0; i < x; i++){   
                conexao20.write(dado.get(i)[20]);
                conexao20.newLine();
            }
            conexao20.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw21 = new FileWriter(f22, true);
            BufferedWriter conexao21 = new BufferedWriter(fw21);
            for(int i = 0; i < x; i++){   
                conexao21.write(dado.get(i)[21]);
                conexao21.newLine();
            }
            conexao21.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw22 = new FileWriter(f23, true);
            BufferedWriter conexao22 = new BufferedWriter(fw22);
            for(int i = 0; i < x; i++){   
                conexao22.write(dado.get(i)[22]);
                conexao22.newLine();
            }
            conexao22.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw23 = new FileWriter(f24, true);
            BufferedWriter conexao23 = new BufferedWriter(fw23);
            for(int i = 0; i < x; i++){   
                conexao23.write(dado.get(i)[23]);
                conexao23.newLine();
            }
            conexao23.close();

           ////////////////////////////////////////////////////////////////
            FileWriter fw24 = new FileWriter(f25, true);
            BufferedWriter conexao24 = new BufferedWriter(fw24);
            for(int i = 0; i < x; i++){   
                conexao24.write(dado.get(i)[24]);
                conexao24.newLine();
            }
            conexao24.close();
            
            ////////////////////////////////////////////////////////////////
            FileWriter fw25 = new FileWriter(f26, true);
            BufferedWriter conexao25 = new BufferedWriter(fw25);
            for(int i = 0; i < x; i++){   
                conexao25.write(dado.get(i)[25]);
                conexao25.newLine();
            }
            conexao25.close();
            
           ////////////////////////////////////////////////////////////////
            long elapsed = System.currentTimeMillis() - start;
            tempo3 += elapsed;
       }
       
    
}