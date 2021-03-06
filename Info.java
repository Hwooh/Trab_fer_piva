/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRAB_INTER_FER;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import java.util.List;
import oshi.hardware.GlobalMemory;
import oshi.hardware.PhysicalMemory;


/**
 *
 * @author pablo
 */
public class Info {
    
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        
        public void getProcessador(){
            System.out.println("Informações do Processador:");
            System.out.println("");
            System.out.println(processor.toString());
            System.out.println("");
        }
        
        List<HWDiskStore> disco = hardware.getDiskStores();
        
        public void getDisco(){
            for (HWDiskStore infodisk : disco) {
                System.out.println("Informações do disco:");
                System.out.println("");
                System.out.println("Modelo do disco: " + infodisk.getModel());
                System.out.println("Tamanho do disco: " + infodisk.getSize()*Math.pow(10,-9) + "Gb");
                System.out.println("Tempo de transferencia: " + infodisk.getTransferTime());
                System.out.println("");
            }
        }
        
        
        GlobalMemory ram = hardware.getMemory();
        List<PhysicalMemory> pm = ram.getPhysicalMemory();
        
        public void getRAM(){
            for (PhysicalMemory inforam : pm) {
                System.out.println("Informações da memoria RAM:");
                System.out.println("");
                System.out.println("Slot em que esta conectado: " + inforam.getBankLabel());
                System.out.println("Capacidade da memória: " + inforam.getCapacity()*Math.pow(10,-9) + "Gb");
                System.out.println("Velocidade de clock: " + inforam.getClockSpeed());
                System.out.println("Tipo da memória: " + inforam.getMemoryType());
                System.out.println("");   
            }
        }
        
        
        
}
