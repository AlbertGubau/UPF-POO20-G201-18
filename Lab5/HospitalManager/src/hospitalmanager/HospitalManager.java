/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;
import java.util.LinkedList;


public class HospitalManager{
	
    private static LinkedList< Hospital > hospitals; //ATRIBUTOS DE LA CLASE
    private static LinkedList< Doctor > doctors;
    private static LinkedList< Administrative > administratives;
    public static Date currentDate;

    public HospitalManager(){ //MÉTODO CONSTRUCTOR
        hospitals = new LinkedList< Hospital >();
        doctors = new LinkedList< Doctor >();
        administratives = new LinkedList< Administrative >();
    }

    public void addHospital( String name ){ //MÉTODO PARA AÑADIR HOSPITALES
        hospitals.add( new Hospital( name ) );
    }

    public void addDoctor( int id, String name ){ //MÉTODO PARA AÑADIR DOCTORES
        doctors.add( new Doctor( id, name ) );
    }

    public void addAdministrative( int id, String name, Hospital h ){ //MÉTODO PARA AÑADIR ADMINISTRATIVOS
        administratives.add( new Administrative( id, name, h ) );
    }

    public Hospital getHospital( int idx ){ return hospitals.get( idx ); } //GETTER DE HOSPITALES

    public Doctor getDoctor( int idx ){ return doctors.get( idx ); } //GETTER DE DOCTORES

    public Administrative getAdmin( int idx ){ return administratives.get( idx ); } //GETTER DE ADMINISTRATIVOS

    public static void dayPass(){
        
        int currentDay = currentDate.getDay();   //TOMAMOS EL DIA ACTUAL
        int currentMonth = currentDate.getMonth();
        int currentYear = currentDate.getYear();
       
        currentDay++; //LO INCREMENTAMOS SEGUN LOS MESES Y LOS AÑOS PARA MANTENER LA LOGICA DE LAS FECHAS
        
        if(currentDay==32){
            
            currentDay = 1;
            currentMonth++;
            if(currentMonth == 13){
                
                currentMonth = 1;
                currentYear++;
            }
        }
        for(Doctor d: doctors){         //COMPROVAMOS SI LA FECHA COINCIDE CON UNA FECHA DE UNA VISITA
            
            for(Visit v: d.getVisits()){
                
                if(currentDate.equals(v.date)){ //SI LA FECHA COINCIDE CON UNA FECHA DE UNA VISITA LA REALIZAMOS
                    
                    Patient patient = v.patient;
                    patient.addVisit(v);
                    d.removeVisit(v);
                }
            }
        }
        currentDate.setDay(currentDay); //ACTUALIZAMOS EL DIA EN EL QUE ESTAMOS CON LA NUEVA FECHA
        currentDate.setMonth(currentMonth);
        currentDate.setYear(currentYear);
    }
    
    public static void main( String args[] ){
   
        currentDate = new Date(29,10,2020); //INICIALIZAMOS LA FECHA ACTUAL
        
        System.out.println("The current date is " + currentDate.getDay()+"/"+currentDate.getMonth() + "/" + currentDate.getYear()+".\n");
        
        HospitalManager hm = new HospitalManager(); //CREAMOS UNA INSTANCIA DE HOSPITAL MANAGER Y AÑADIMOS LOS ELEMENTOS

        hm.addHospital( "Hospital Sant Joan de Deu" );
        hm.addHospital( "Hospital de Barcelona" );
        
        hm.addDoctor( 1, "Joline" ); //AÑADIMOS DOCTORES
        hm.addDoctor( 2, "Antoine" );

        hm.addAdministrative( 3, "Clarise", hm.getHospital( 0 ) ); //AÑADIMOS ADMINISTRATIVOS
        hm.addAdministrative( 4, "Pere", hm.getHospital( 1 ) );
        
        dayPass();
        
        for( int id = 0; id < 2; id++ ){ //AÑADIMOS HABITACIONES Y CAMAS
            for( int h = 0; h < 2; h++ ){
                hm.getHospital( h ).addRoom( id );
                for( int b = 0; b < 2; b++ ){
                    hm.getHospital( h ).getRoom( id ).addBed( b );
                }
            }
        }

        hm.getHospital( 0 ).addAdmin( hm.getAdmin( 0 ) ); //AÑADIMOS LOS ADMINISTRATIVOS AL HOSPITAL
        hm.getHospital( 1 ).addAdmin( hm.getAdmin( 1 ) );

        hm.getHospital( 0 ).addDoctor( hm.getDoctor( 0 ) ); //AÑADIMOS LOS DOCTORES AL HOSPITAL
        hm.getHospital( 0 ).addDoctor( hm.getDoctor( 1 ) );
        hm.getHospital( 0 ).getDoctor( 0 ).addSpeciality( "General" ); //AÑADIMOS LAS ESPECIALIDADES DE LOS DOCTORES
        hm.getHospital( 0 ).getDoctor( 1 ).addSpeciality( "General" );
        hm.getHospital( 0 ).getDoctor( 1 ).addSpeciality( "Cardiologist" );
        hm.getHospital( 1 ).addDoctor( hm.getDoctor( 0 ) );

        dayPass();
        
        for( int i = 0; i < 2; i++ ){ //IMPRIMIMOS PPOR PANTALLA LAS ESPECIALIDADES Y LAS VISITAS DE LOS DOCTORES
            Doctor d = hm.getDoctor( i );
            d.listSpecialities();
            d.listVisits();		
            System.out.println();
        }
        System.out.println();

        dayPass();
        
        hm.getHospital( 0 ).addResident( 87634, "Jaume", 19 ); //AÑADIMOS PACIENTES DE TIPO RESIDENTE Y DE TIPO VISITANTE
        hm.getHospital( 0 ).addResident( 34532, "Monica", 25);
        hm.getHospital( 0 ).addResident( 62452, "German", 50);
        hm.getHospital( 0 ).addResident( 21411, "Maria", 37 );
        hm.getHospital( 0 ).addResident( 12999, "Francesc", 88);
        hm.getHospital( 0 ).addVisitor( 78678, "Carme", 63);

        hm.getHospital( 1 ).addVisitor( 12841, "Xavi", 43 );
        hm.getHospital( 1 ).addVisitor( 26256, "Fatima",65 );
        hm.getHospital( 1 ).addVisitor( 62213, "Johan",22 );
        hm.getHospital( 1 ).addVisitor( 26268, "Johanna",10 );
        hm.getHospital( 1 ).addVisitor( 99887, "Jan",90 );

        hm.getHospital( 0 ).getAdmin( 0 ).addVisit( new Date(1,12,2020), "Is a cold", hm.getHospital( 0 ).getDoctor( 0 ), hm.getHospital( 0 ).getPatient( 0 ) ); //AÑADIMOS VISITAS
        hm.getHospital( 0 ).getAdmin( 0 ).addVisit( new Date(2,12,2020), "Undefined, visit with cardiologist", hm.getHospital( 0 ).getDoctor( 1 ), hm.getHospital( 0 ).getPatient( 1 ) );
        hm.getHospital( 1 ).getAdmin( 0 ).addVisit( new Date(3,12,2020), "Is a cold", hm.getHospital( 0 ).getDoctor( 0 ), hm.getHospital( 0 ).getPatient( 3 ) );

        hm.getHospital( 0 ).assignBeds( 0 ); //ASIGNAMOS LAS CAMAS A LOS RESIDENTES
        hm.getHospital( 0 ).sortPatients(); //ORDENAMOS LOS PACIENTES POR EDAD
        hm.getHospital( 1 ).sortPatients();
        
        dayPass(); //ACUALIZAMOS LA FECHA ACTUAL
        
        System.out.println();
        
        for( int i = 0; i < 2; i++ ){
            System.out.println( hm.getHospital( i ) ); //IMPRIMIMOS POR PANTALLA LOS HOSPITALES
        }
        
        System.out.println("The current date is " + currentDate.getDay()+"/"+currentDate.getMonth() + "/" + currentDate.getYear()+".\n"); //IMPRIMIMOS POR PANTALLA LA FECHA EN LA QUE ESTAMOS
    }
}
