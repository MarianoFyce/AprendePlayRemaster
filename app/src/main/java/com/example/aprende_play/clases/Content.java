package com.example.aprende_play.clases;

public class Content {


    public static String Pregunta(int N_Pregunta) {
        String cadena = "";
        switch (N_Pregunta) {
            case 1:
                cadena = "A medida que transcurre el tiempo, la pandemia por coronavirus-2019\n" +
                        "(COVID-19) afecta negativamente a la sociedad." +
                        "Las familias con un hijo,\n" +
                        "hija o familiar con un trastorno del neurodesarrollo como el Trastorno del\n" +
                        "Espectro Autista (TEA) " +
                        "son particularmente vulnerables a las medidas de\n" +
                        "distanciamiento físico y podrían mostrar mayores problemas de ansiedad\n" +
                        "y angustia secundarios a la complejidad en el manejo dentro del hogar que\n" +
                        "conllevan las personas con esta condición.\n" +

                        "Por este motivo, creemos de\n" +
                        "suma importancia brindar algunas recomendaciones para todos los\n" +
                        "padres, madres y cuidadores de personas con dicha condición, durante\n" +
                        "este periodo de emergencia sanitaria. ";


                ;
                break;
            case 2:
                cadena = "1.- PERMANEZCA CALMADO Y TRANSMITA TRANQUILIDAD.\n" +
                        "Aunque no nos demos cuenta, las personas con TEA pueden reaccionar a\n" +
                        "su estado emocional y a la forma o tono de sus conversaciones. Por lo tanto,\n" +
                        "es importante proyectar una actitud de calma y tranquilidad durante esta\n" +
                        "situación de emergencia. \n\n" +

                        "2.- APOYE LA COMPRENSIÓN CON AYUDAS VISUALES Y NARRATIVAS\n" +
                        "SOCIALES.\n" +
                        "Para apoyar a las personas con TEA que entiendan sobre COVID-19, la\n" +
                        "comunicación es mejor cuando se combina con ayudas visuales o\n" +
                        "narrativas (historias simples que explican una situación social). Estas\n" +
                        "estrategias le permitirán a la persona con TEA la oportunidad de procesar\n\n" +

                        "3.- PROPORCIONAR ESTRUCTURA Y RUTINAS.\n" +
                        "Las personas con TEA funcionan mejor cuando se les proporciona una\n" +
                        "rutina estructurada que les permite anticipar lo que sucederá cada día. En\n" +
                        "la medida de lo posible, siga las rutinas previamente establecidas\n" +
                        "relacionadas con las actividades de la vida diaria (sueño, alimentación,\n" +
                        "tareas y juego). Un horario visual ayudará a su hijo a comprender la nueva\n" +
                        "estructura de su rutina diaria en el hogar. Es apropiado que el tiempo de\n" +
                        "exposición a pantallas digitales sea limitado dentro del horario diario. \n\n" +

                        "4.- PROMOVER EL CONTACTO CON LA FAMILIA.\n" +
                        "El mantener contacto con los seres queridos a través de redes telefónicas o\n" +
                        "video llamadas es favorable, puesto que les permite continuar las\n" +
                        "relaciones sociales con los demás. Aún cuando inicialmente podría no\n" +
                        "interesarle dicha interacción, el buscar favorecerla, es una estrategia\n" +
                        "recomendada. Recuerde que el distanciamiento físico no es lo mismo que\n" +
                        "el distanciamiento social." ;


                break;
            default:
                cadena = "Opcion no valida";
                break;

        }
        return cadena;

    }
}
