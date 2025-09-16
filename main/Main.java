
package com.mycompany.main;

import service.FasilitasService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            FasilitasService fasilitasService = new FasilitasService();
            int pilihan;
            
            do {
                System.out.println("\n=== MENU FASILITAS GYM ===");
                System.out.println("1. Tambah Fasilitas");
                System.out.println("2. Lihat Fasilitas");
                System.out.println("3. Update Fasilitas");
                System.out.println("4. Hapus Fasilitas");
                System.out.println("5. Cari Fasilitas");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine();
                
                switch (pilihan) {
                    case 1 -> fasilitasService.tambahFasilitas(scanner);
                    case 2 -> fasilitasService.lihatFasilitas();
                    case 3 -> fasilitasService.updateFasilitas(scanner);
                    case 4 -> fasilitasService.hapusFasilitas(scanner);
                    case 5 -> fasilitasService.cariFasilitas(scanner);
                    case 6 -> System.out.println("Keluar dari program...");
                    default -> System.out.println("️Pilihan tidak valid!");
                }
            } while (pilihan != 6);
        }
    }
}
