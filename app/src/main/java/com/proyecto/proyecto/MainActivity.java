package com.proyecto.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    public static ArrayList<Categoria> listacategorias = new ArrayList<>();
    public static ArrayList<Evento> listaeventos = new ArrayList<>();

    BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio | Categorias");
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menunav);
        fragmentManager = getSupportFragmentManager();

        cargarCategorias();

        HomeFragment homeFragment1 = new HomeFragment();
        fragmentManager.beginTransaction().add( R.id.contenido, homeFragment1, HomeFragment.class.getName() ).commit();

        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i("a", item.getTitle().toString());
                if ("Inicio".equals(item.getTitle())) {
                    HomeFragment homeFragment = new HomeFragment( );
                    fragmentManager.beginTransaction().add( R.id.contenido, homeFragment, HomeFragment.class.getName() ).addToBackStack(null).commit();
                    setTitle("Inicio | Categorias");
                    return true;
                }else if ("Buscar".equals(item.getTitle())) {
                    BuscarFragment buscarFragment = new BuscarFragment( );
                    fragmentManager.beginTransaction().add( R.id.contenido, buscarFragment, HomeFragment.class.getName() ).addToBackStack(null).commit();
                    setTitle("Buscar");
                    return true;
                }else if ("Perfil".equals(item.getTitle())) {
                    PerfilFragment perfilFragment = new PerfilFragment( );
                    fragmentManager.beginTransaction().add( R.id.contenido, perfilFragment, HomeFragment.class.getName() ).addToBackStack(null).commit();
                    setTitle("Perfil");
                    return true;
                }else{
                    return false;
                }
            }
        });
    }

    private void cargarCategorias() {
        Categoria conferencia = new Categoria( "Conferencia",R.drawable.confer1 );
        Categoria taller = new Categoria( "Taller", R.drawable.tall1 );
        Categoria concierto = new Categoria( "Concierto", R.drawable.conciert1 );
        Categoria curso = new Categoria( "Curso", R.drawable.curs1 );

        this.listacategorias.add( conferencia );
        this.listacategorias.add( taller );
        this.listacategorias.add( concierto );
        this.listacategorias.add( curso );

        this.listaeventos.add( new Evento("GBTA Conferencia", "15/12/2021", "Puebla centro, zaragoza 115", "La Conferencia GBTA tiene temáticas relacionadas a la Industria de viajes corporativos, reuniones e incentivos con speakers nacionales e internacionales, y líderes de la industria que comparten su visión en un foro colaborativo que promueve la profesionalización de sus asistentes", conferencia) );
        this.listaeventos.add( new Evento("Gran Slam", "15/12/2021", "Puebla centro, zaragoza 115", "Los Grand Slam son los 4 torneos más importantes del circuito de tenis y se disputan cada año. En categoría masculina los partidos se juegan al mejor de 5 sets (a diferencia del resto de campeonatos del calendario que se disputan al mejor de 3)", conferencia) );
        this.listaeventos.add( new Evento("POP Life! The Pop Culture Festival\n", "15/12/2021", "Puebla centro, zaragoza 115", "Este festival reúne a través de la música, expositores, conferencias, actividades, fotografía, cine y más, lo mejor de las décadas de los 80´s y 90´s. Fusionamos toda una generación que nos identificó", conferencia) );
        this.listaeventos.add( new Evento("Feria Nacional de Bebidas Típicas 2022\n", "15/12/2021", "Puebla centro, zaragoza 115", "Este festival se llevará a cabo del 1 al 3 de diciembre en Expo Reforma. Mucho se habla sobre la gastronomía alrededor del mundos", conferencia) );
        this.listaeventos.add( new Evento("FORO FINTECH MÉXICO\n", "15/12/2021", "Puebla centro, zaragoza 115", "Fintech es un conjunción abreviada de los términos “finanzas” y “tecnología” en inglés y se refiere a cualquier negocio que utilice la tecnología para mejorar o automatizar los servicios y procesos financieros", conferencia) );
        this.listaeventos.add( new Evento("Feria Internacional de Tecnología y Manufactura - FITMA\n", "15/12/2021", "Puebla centro, zaragoza 115", "La misión de FITMA es la de desarrollar una exposición especializada para el sector metalmecánico, de carácter internacional, que conecte la cadena de suministro de la manufactura global con el rápido crecimiento del mercado industrial de América Latina", conferencia) );
        this.listaeventos.add( new Evento("MUA\n", "15/12/2021", "Puebla centro, zaragoza 115", "MUA informa a la comunidad sobre su derecho a recibir servicios en su idioma en cualquier agencia pública de la Ciudad, como lo indica la Ordenanza de Acceso Lingüístico de San Francisco, y provee asistencia directa a miembras que necesiten hacer una queja por falta de servicios en su idioma o mala calidad de los mismos", conferencia) );
        this.listaeventos.add( new Evento("Preguntas Frecuentes Expositores\n", "15/12/2021", "Puebla centro, zaragoza 115", "El Congreso de la UICN, que se celebra cada cuatro años, es el evento de conservación más grande del mundo. Reúne a líderes de gobiernos", conferencia) );
        this.listaeventos.add( new Evento("Hacia la construcción de ciudades del aprendizaje sostenibles", "15/12/2021", "Ciudad de Mexico", "Conferencia Internacional sobre Ciudades de Aprendizaje (ICLC), organizada por la UNESCO y el Gobierno de la Ciudad de México", conferencia) );
        this.listaeventos.add( new Evento("TI general Ferias 2022 - 2023", "15/12/2021", "Puebla centro, zaragoza 115", "Conferencia y Exposición Internacional de Tecnologías de la Educación y el Aprendizaje y Tecnologías de la Información y la Comunicación", conferencia) );


        this.listaeventos.add( new Evento("Taller de danza ", "10/01/2022", "Centro de artes Hidalgo numero 22", "taller de danza es una forma de ensenar la danza, de modo que lo más importante es utilizar el movimiento como “material” de creación o crear nuevos materiales para los fines de la propia danza", taller) );
        this.listaeventos.add( new Evento("Taller de musica", "10/01/2022", "Centro de artes Hidalgo numero 22", "Es un curso teórico-práctico que tiene como propósito que el estudiante conozca y experimente los elementos de la música en las artes escénicas y el vocabulario musical básico para su aplicación en la comprensión y ejecución musical, a través de la interpretación musical básica en canto", taller) );
        this.listaeventos.add( new Evento("Taller de Matemáticas", "10/01/2022", "Centro de artes Hidalgo numero 22", "Taller de Matemáticas ha de proporcionar al alumnado la oportunidad de incorporar las matemáticas al bagaje de saberes que le son útiles en la vida diaria, fortaleciendo las relaciones que hay entre las matemáticas y el mundo que le rodea; donde desarrolle su gusto por la actividad matemática", taller) );
        this.listaeventos.add( new Evento("Taller creativo", "10/01/2022", "Centro de artes Hidalgo numero 22", "Los talleres creativos pueden proveer una visión perspicaz invaluable de perspectivas ajenas respecto a temas particulares", taller) );
        this.listaeventos.add( new Evento("Taller de artes", "10/01/2022", "Centro de artes Hidalgo numero 22", "Los talleres de educación artística contribuyen al desarrollo integral de los niños y adolescentes porque les ayudan a expresar su creatividad y sensibilidad", taller) );
        this.listaeventos.add( new Evento("Taller de construccion", "10/01/2022", "Centro de artes Hidalgo numero 22", "Se ubica antes de las materias de Administración de la Construcción ya que le permitirá comprender el proceso constructivo lógico para posteriormente llevar a cabo la planeación, organización y control de obra.\n", taller) );
        this.listaeventos.add( new Evento("Taller de cocina", "10/01/2022", "Centro de artes Hidalgo numero 22", "Esto los ayuda a fortalecer su identidad, seguridad y espíritu ingenioso. Para muchos pequeños aprendices de cocinero, preparar platos que gusten los ayuda a mantener la motivación, enfoque y a seguir intentándolo hasta alcanzar la perfección", taller) );
        this.listaeventos.add( new Evento("Taller de manualidades", "10/01/2022", "Centro de artes Hidalgo numero 22", "Tener la oportunidad de crear es una de las experiencias más enriquecedoras que puede tener un niño, ya sea haciendo uso de materiales reciclados o de herramientas de última tecnología como impresoras 3D, el proceso creativo desarrolla la imaginación, fomenta la creatividad, la curiosidad y  mejora la motricidad", taller) );
        this.listaeventos.add( new Evento("Taller informatica", "10/01/2022", "Centro de artes Hidalgo numero 22", "El mundo cambia y las actividades extraescolares también, es fundamental que nuestros hijos cuenten con conocimientos que les permitan salir adelante en el mundo actual, y la informática es uno de ellos.\n" +
                "\n", taller) );
        this.listaeventos.add( new Evento("Taller de artes marciales", "10/01/2022", "Centro de artes Hidalgo numero 22", "Este tipo de actividades tiene todos los beneficios de los deportes en general, pero aparte da la posibilidad de acercarse un poco a otras culturas. Las artes marciales son un ejemplo claro de disciplina y compromiso", taller) );


                this.listaeventos.add( new Evento("PXNDX", "15/12/2021", "CDMX", "Compra boletos para PXNDX en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Linkin Park", "16/12/2021", "CDMX", "El concierto homenaje a Chester Bennington, Compra boletos en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Imagine Dragons", "17/12/2021", "CDMX", "Compra boletos para Imagine Dragons en Ticketmaster MX. Imagine Dragons", concierto) );
        this.listaeventos.add( new Evento("Twenty One Pilots\n", "18/12/2021", "CDMX", "Compra boletos para PXNDX en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Green Day\n", "19/12/2021", "CDMX", "Compra boletos para Green Day en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Hoobastank", "20/12/2021", "CDMX", "Compra boletos para Hoobastank en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Avril Lavigne\n", "21/12/2021", "CDMX", "Compra boletos para Avril Lavigne en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Elefante", "22/12/2021", "CDMX", "Compra boletos para Elefante en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("Starset", "23/12/2021", "CDMX", "Compra boletos para Starset en Ticketmaster MX", concierto) );
        this.listaeventos.add( new Evento("State of Mind", "25/12/2021", "CDMX", "Compra boletos para State of Mind en Ticketmaster MX\n", concierto) );


        this.listaeventos.add( new Evento("Curso de programacion", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Este curso te enseñará a pensar como un programador, creando algoritmos y aplicando soluciones en lenguajes de programación reales", curso) );
        this.listaeventos.add( new Evento("Curso Inglés", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Aprender inglés en tiempo récord es posible con Berlitz. Nuestras clases son 100% personalizables para que las adaptes a tu vida y les saques el mejor", curso) );
        this.listaeventos.add( new Evento("Curso de contabilidad", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Dirigida a aquellos que cuentan con habilidades de carácter matemático. ¡Infórmate! Formamos profesionales de la contaduría que proporcionan información financiera.\n", curso) );
        this.listaeventos.add( new Evento("Cursos de Administración", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Tiene la finalidad de conocer, comprender y aplicar los procesos de planeación, organización, dirección y control de los recursos de una empresa; mediante el estudio del liderazgo, la gestión administrativa, logística y financiera, la cual es necesaria para dirigir un negocio o empresa", curso) );
        this.listaeventos.add( new Evento("Cursos de Márketing", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Conviértete en un experto de marketing digital a un nivel básico con nuestro curso gratuito acreditado por la agencia Interactive ", curso) );
        this.listaeventos.add( new Evento("Cursos de Liderazgo", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "El curso de liderazgo tiene el propósito que el aprendiz conozca y comprenda la manera como se puede influenciar a las personas", curso) );
        this.listaeventos.add( new Evento("Cursos en formación de gestión", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Este programa de formación está creado para favorecer que el alumno que lo siga pueda tener una visión clara de la gestión por procesos", curso) );
        this.listaeventos.add( new Evento("Cursos en Gestión de riesgos", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Especialízate en gestión de riesgos financieros y aprende a reaccionar ante los problemas. Fórmate en 8 semanas con un formato totalmente online", curso) );
        this.listaeventos.add( new Evento("Curso Español", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Cursos de español pueden ser la opción ideal para las personas que deseen aprender una segunda lengua que podrían ser de utilidad en el día a día de la vida, así como en los negocios. Español es un lenguaje versátil, que se habla en todo el mundo. ¿Qué es un curso de idiomas en español? Un curso de español enseña a los estudiantes a hablar el idioma, además de escribir y leer", curso) );
        this.listaeventos.add( new Evento("Curso Contabilidad", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Los cursos en contabilidad son una excelente manera de diversificar educación y experiencia a la vez que los estudiantes mejoran su capacidad profesional, ya sean contables en busca de refrescar conocimientos o estén interesados en un cambio de carrera. Hay cursos en Contabilidad disponibles en varios países y cada uno es específico para un área en particular", curso) );
        this.listaeventos.add( new Evento("Curso Negocios", "15/01/2022", "Xicotepec de Juarez, Centro numero34", "Los cursos en Negocios pueden complementar tu experiencia profesional y académica, ya lleves en el mundo empresarial mucho tiempo o estés buscando un cambio profesional. Hay muchas instituciones educativas en todo el mundo que imparten educación empresarial de calidad por parte de un profesorado profesional", curso) );

    }

    public static ArrayList<Categoria> getCategorias(){
        return listacategorias;
    }
    public static ArrayList<Evento> getEventos(){
        return listaeventos;
    }
    public static Context getContext(){
        return getContext();
    }
}