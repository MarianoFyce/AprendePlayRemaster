package com.example.aprende_play.abel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.example.aprende_play.Inicio;
import com.example.aprende_play.R;

public class Terminos_condiciones extends AppCompatActivity {

    Button back;
private TextView cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_condiciones);


        back= (Button)findViewById(R.id.aceptar);

cont= (TextView)findViewById(R.id.txtContenido1);




        cont.setText("1. PROTECCIÓN DE DATOS\n" +
                "El 24 de abril de 2019 entra en vigor una nueva ley publicada en el Diario Oficial de la Federación llamada Ley General de Protección de Datos Personales en Posesión de sujetos Obligados. Esta regulación está diseñada para unificar todas las leyes de protección de datos dentro del territorio Mexicano y proporcionar un mayor nivel de control para las personas sobre cómo las organizaciones pueden manejar y usar sus datos.\n" +
                "Nos comprometemos a proteger tu privacidad y trabajar dentro de los límites establecidos por dicho Reglamento.\n" +
                "La Ley General de Protección de Datos Personales en Posesión de sujetos Obligados, otorga cinco derechos específicos a los individuos, y reconocemos nuestra responsabilidad al proporcionar esos derechos:\n" +
                "VI  Garantizar que toda persona pueda ejercer el derecho a la protección de los datos personales\n" +
                "VIII. Consentimiento: Esto implica que tienes derecho a recibir información de cómo serán tratados tus datos personales que compartas dentro de la aplicación.\n" +
                "IX. Datos personales: Los datos personales que compartas, son considerados de una persona física, es decir que es real y existente.\n" +
                "X. Datos personales sensibles: Aquellos que se refieran a la esfera más íntima de su titular, o cuya utilización indebida pueda dar origen a discriminación o conlleve un riesgo grave para éste. De manera enunciativa más no limitativa, se consideran sensibles los datos personales que puedan revelar aspectos como origen racial o étnico, estado de salud presente o futuro, información genética, creencias religiosas, filosóficas y morales, opiniones políticas y preferencia sexual; \n" +
                "\n" +
                "XXIII. Medidas de seguridad técnicas: Conjunto de acciones y mecanismos que se valen de la tecnología relacionada con hardware y software para proteger el entorno digital de los datos personales y los recursos involucrados en su tratamiento. De manera enunciativa más no limitativa, se deben considerar las siguientes actividades: a) Prevenir que el acceso a las bases de datos o a la información, así como a los recursos, sea por usuarios identificados y autorizados; b) Generar un esquema de privilegios para que el usuario lleve a cabo las actividades que requiere con motivo de sus funciones; c) Revisar la configuración de seguridad en la adquisición, operación, desarrollo y mantenimiento del software y hardware, y d) Gestionar las comunicaciones, operaciones y medios de almacenamiento de los recursos informáticos en el tratamiento de datos personales;\n" +
                "No vendemos, comercializamos ni transferimos a terceros tu información de identificación personal. Esto no incluye a los terceros de confianza que nos ayudan a operar nuestra aplicación móvil o brindarle servicio, siempre que dichas partes acuerden mantener esta información confidencial. También podemos divulgar su información cuando consideremos que la divulgación es apropiada para cumplir con la ley, hacer cumplir las políticas de nuestro página o proteger nuestros derechos, propiedad o seguridad.\n" +
                "2. EXCLUSIONES DE RESPONSABILIDAD\n" +
                "Hacemos todos los esfuerzos razonables para garantizar que los datos en la aplicación móvil sean precisos y para corregir cualquier error u omisión tan pronto como sea posible después de tener conocimiento de ellos.\n" +
                "No supervisamos, verificamos ni respaldamos la información presentada por terceros para su publicación y se debe tener en cuenta que dicha información puede ser inexacta, incompleta o desactualizada.\n" +
                "En la medida permitida por la ley aplicable, rechazamos todas las garantías y declaraciones (ya sean expresas o implícitas) en cuanto a la exactitud de cualquier información contenida en la aplicación móvil.\n" +
                "No garantizamos que la aplicación móvil esté libre de fallos y no aceptamos responsabilidad por errores u omisiones.\n" +
                "Debido a la naturaleza de la transmisión electrónica de datos a través de Internet, y la cantidad de usuarios por los cuales se publican datos en la aplicación móvil, cualquier responsabilidad que podamos tener por las pérdidas o reclamaciones derivadas de la imposibilidad de acceder a la aplicación móvil, o de cualquier el uso de la aplicación móvil o la dependencia de los datos transmitidos mediante la aplicación móvil están excluidos en la mayor medida permitida por la ley.\n" +
                "En ningún caso seremos responsables de ninguna pérdida de beneficios, ingresos, buena voluntad, oportunidad, negocio, ahorros anticipados u otras pérdidas indirectas o consecuentes de ningún tipo en contrato, responsabilidad extracontractual (incluida negligencia) o que de otro modo surjan del uso de la aplicación móvil, salvo cuando tal responsabilidad no pueda ser excluida por la ley.\n" +
                "No damos ninguna garantía de que la aplicación móvil esté libre de virus o cualquier otra cosa que pueda tener un efecto nocivo en cualquier tecnología.\n" +
                "\n" +
                "\n" +
                "3. DATOS ENVIADOS POR LOS USUARIOS\n" +
                "No aceptamos ninguna responsabilidad por los datos suministrados por cualquier usuario para mostrar en la aplicación móvil. Además, se aplican las limitaciones en el apartado 3 anterior (Exclusiones de responsabilidad).\n" +
                "Si envías datos para su visualización en la aplicación móvil, eres responsable de garantizar que los datos sean precisos, completos y actualizados, y de actualizar esos datos cuando sea necesario.\n" +
                "Si envías datos para su visualización en la aplicación móvil, eres responsable de garantizar que no se carguen ni envíen datos que sean falsos, difamatorios, obscenos o abusivos u desagradables o que infrinjan las leyes o los derechos aplicables de terceros.\n" +
                "Deberás que has tomado todas las precauciones razonables para que los datos que carguen en o que envíen a la aplicación móvil estén libres de virus y cualquier otra cosa que pueda tener un efecto contaminante o destructivo en cualquier parte de la aplicación móvil o de cualquier otra tecnología.\n" +
                "Nos reservamos el derecho (sin limitar nuestros derechos a buscar otros remedios) de eliminar el material ofensivo colocado en la aplicación móvil que consideramos que constituye un uso indebido de la aplicación o que es perjudicial para otros usuarios de la misma.\n" +
                "Deberás indemnizarnos por cualquier reclamación o pérdida (incluidas, entre otras, pérdidas económicas) sufridas por nosotros como consecuencia del incumplimiento de cualquiera de los términos de estas condiciones.\n" +
                "\n" +
                "\n" +
                "3. PROPIEDAD INTELECTUAL\n" +
                "Los derechos de autor en el diseño de la aplicación móvil, texto y gráficos, y su selección y disposición, así como el software y el código fuente subyacente existen bajo una licencia Creative Commons.\n" +
                "El derecho de autor sobre el contenido de la aplicación reside en sus autores y la responsabilidad con los proveedores de dicha información. Ninguno de estos materiales puede ser reproducido o redistribuido sin atribución a los autores.\n" +
                "El nombre de APRENDE PLAY S.A es propiedad de sus autores, Mariano Rosas Ortiz, Daniel Damar García Colorado y Miguel Abel González Ojeda. Otros productos y nombres de empresas mencionados en esta aplicación móvil pueden ser los dominios, marcas comerciales o marcas comerciales registradas de sus respectivos propietarios.\n" +
                "Deberás conservar la propiedad de todos los derechos de autor sobre los datos que envíes a la página web bajo la licencia de Creative Commons. Otorgas a la comunidad una licencia mundial, sin regalías, no rescindible para usar, copiar, distribuir tales datos de cualquier manera con la mención del autor.\n" +
                "\n" +
                "\n" +
                "GENERAL\n" +
                "Si alguna disposición de estos términos y condiciones se considera ilegal, inválida o inaplicable, dicha disposición se considerará cortada y la validez y aplicabilidad de las disposiciones restantes de estos términos y condiciones no se verán afectadas.\n" +
                "Podemos modificar estos términos y condiciones en cualquier momento mediante la publicación de los términos y condiciones modificados en la aplicación móvil.\n" +
                "\n");

        back.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Inicio.class));
            finish();
        });

    }
}