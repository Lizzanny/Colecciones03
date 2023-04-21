/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Alumno.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LizzW
 * 
 * Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
public class Servicios {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    ArrayList<Alumno> listaAlumnos = new ArrayList();
    
    
    public void crearAlumno(){
        boolean salir=false;
        do{
            System.out.print("¿Desea agregar un nuevo alumno? \n"
            +"1. Si\n"
            +"2. No\n"
            +"Opción: ");
            
            switch (sc.nextInt()) {
                case 1:
                    listaAlumnos.add(new Alumno());//otra forma de instanciar
                break;
                case 2:
                    salir=true;
                break;
                default:
                    System.out.println("Opción invalida");
            }
        }while(!salir);
    }
    
    public void listarAlumnos(){
        for (Alumno listaAlumno : listaAlumnos) {
            System.out.println("Las notas de "+listaAlumno.getNombre()+" son: "+listaAlumno.getNotas()); 
        }
    }
    
    public void notaFinal(){
        String alumno;
        System.out.println("Ingrese el nombre del alumno: ");
        alumno = sc.next();
        double fin=0;
        for (Alumno listaAlumno : listaAlumnos) {
            if(listaAlumno.getNombre().equalsIgnoreCase(alumno)){
                System.out.println("Las notas de "+listaAlumno.getNombre()+" son: "+listaAlumno.getNotas());
                for (int i = 0; i < listaAlumno.getNotas().size(); i++) {
                    fin+= listaAlumno.getNotas().get(i);
                }
            }
        }
        if(fin!=0){
            System.out.println("Promedio final: " + fin/3);
        }else{
            System.out.println("¡Aviso! Este alumno no se encuentra registrado.");
        }
    }
    
    public void editarNotas(){
        String alumno;
        
        boolean salir=false;
        do{
            System.out.print("Seleccione que desea realizar: \n"
            +"1. Editar todas las notas\n"
            +"2. Editar una nota en especifico\n"
            +"3. Salir\n");
            
            switch (sc.nextInt()) {
                case 1://Editar todas las notas
                    System.out.println("Ingrese el nombre del alumno: ");
                    alumno = sc.next();
                    for (Alumno listaAlumno : listaAlumnos) {
                        if(listaAlumno.getNombre().equalsIgnoreCase(alumno)){
                            System.out.println("Las notas de "+listaAlumno.getNombre()+" son: "+listaAlumno.getNotas());
                            for (int i = 0; i < listaAlumno.getNotas().size(); i++) {
                                System.out.println("Ingrese nota "+(i+1));
                                listaAlumno.getNotas().set(i, sc.nextInt());
                            }
                            System.out.println("Las nuevas notas de "+listaAlumno.getNombre()+" son: "+listaAlumno.getNotas());
                        }
                    }
                break;
                case 2://Editar una nota en especifico
                    
                    System.out.println("Ingrese el nombre del alumno: ");
                    alumno = sc.next();
                    int i;
                    boolean s=false;
                    for (Alumno listaAlumno : listaAlumnos) {
                        if(listaAlumno.getNombre().equalsIgnoreCase(alumno)){
                            System.out.println("Las notas de "+listaAlumno.getNombre()+" son: "+listaAlumno.getNotas());
                            do{
                                System.out.println("Ingrese el numero de nota que desea editar: 1, 2, 3,\n 4. Salir \n Opción: ");
                                i = sc.nextInt();
                                switch (i) {
                                    case 1,2,3 -> {
                                        System.out.println("Ingrese nota "+i);
                                        listaAlumno.getNotas().set((i-1), sc.nextInt());
                                    }
                                    case 4 -> s=true;
                                    default -> System.out.println("Opción invalida");
                                }

                                System.out.println("Las nuevas notas de "+listaAlumno.getNombre()+" son: "+listaAlumno.getNotas());
                            }while(!s);
                        }
                    }
                    
                break;
                case 3://Salir
                    salir=true;
                break;
                default:
                    System.out.println("Opción invalida");
            }
        }while(!salir);
        
    }
    
    public void menu(){
        boolean salir=false;
        do{
            System.out.print("¿Que acción deseas realizar? \n"
            +"1. Crear alumno\n"
            +"2. Listar alumnos\n"
            +"3. Calcular promedio\n"
            +"4. Editar notas\n"
            +"5. Salir\n"
            +"Opción: ");
            
            switch (sc.nextInt()) {
                case 1://Crear alumno
                    crearAlumno();
                break;
                case 2://Mostrar lista alumnos
                    listarAlumnos();
                break;
                case 3://Calcular nota final
                    notaFinal();
                break;
                case 4://Editar notas
                    editarNotas();
                break;
                case 5://Salir
                    System.out.println("Saliendo... ");
                    salir=true;
                break;
                default:
                    System.out.println("Opción invalida");
            }
        }while(!salir);
    }
}
