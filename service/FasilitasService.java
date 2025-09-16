package service;

import models.Fasilitas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FasilitasService {
    ArrayList<Fasilitas> daftarFasilitas = new ArrayList<>();

    public FasilitasService() {
        daftarFasilitas.add(new Fasilitas(1, "Treadmill", "Tersedia"));
        daftarFasilitas.add(new Fasilitas(2, "Dumbbell", "Tersedia"));
    }

    public void tambahFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Fasilitas: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Status Fasilitas: ");
        String status = scanner.nextLine();

        Fasilitas fasilitas = new Fasilitas(id, nama, status);
        daftarFasilitas.add(fasilitas);
        System.out.println("Fasilitas berhasil ditambahkan!");
    }

    public void lihatFasilitas() {
        if (daftarFasilitas.isEmpty()) {
            System.out.println("Belum ada fasilitas yang tersimpan.");
        } else {
            System.out.println("\n=== Daftar Fasilitas ===");
            for (Fasilitas f : daftarFasilitas) {
                System.out.println("ID: " + f.idFasilitas + 
                                   " | Nama: " + f.namaFasilitas + 
                                   " | Status: " + f.status);
            }
        }
    }

    public void updateFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Fasilitas f : daftarFasilitas) {
            if (f.idFasilitas == id) {
                System.out.print("Masukkan Nama Baru: ");
                f.namaFasilitas = scanner.nextLine();
                System.out.print("Masukkan Status Baru: ");
                f.status = scanner.nextLine();
                System.out.println("Data fasilitas berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
    }

    public void hapusFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Iterator<Fasilitas> it = daftarFasilitas.iterator();
        while (it.hasNext()) {
            Fasilitas f = it.next();
            if (f.idFasilitas == id) {
                it.remove();
                System.out.println("Fasilitas berhasil dihapus!");
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
    }

    public void cariFasilitas(Scanner scanner) {
        System.out.print("Masukkan Nama Fasilitas yang ingin dicari: ");
        String namaCari = scanner.nextLine().trim();
        boolean ditemukan = false;

        for (Fasilitas f : daftarFasilitas) {
            if (f.namaFasilitas.toLowerCase().contains(namaCari.toLowerCase())) {
                System.out.println("Ditemukan: ID: " + f.idFasilitas + 
                                   " | Nama: " + f.namaFasilitas + 
                                   " | Status: " + f.status);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Fasilitas dengan nama '" + namaCari + "' tidak ditemukan.");
        }
    }
}
