package Ricardo.Pocasangre.validacionesyspinner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar a todos los elementos
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2- agregar un evento al boton
        btnAgregar.setOnClickListener {
            //validemos que los campos no esten vacios
            if (txtEdad.text.isEmpty()
                || txtCorreo.text.isEmpty()
                || txtContrasena.text.isEmpty()
                || txtDUI.text.isEmpty()
                || txtNombre.text.isEmpty()){
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
            }

            else if (txtEdad.text.matches("[0-9]".toRegex())){
                Toast.makeText(this, "Ocupar solo numero", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "campos agregados", Toast.LENGTH_SHORT).show()
            }
            if (txtCorreo.text.matches("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+]".toRegex())){
                Toast.makeText(this, "correo real", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "correo incorrecto", Toast.LENGTH_SHORT).show()
            }
            
            //validar la contraseña para que tenga mas de 6 digitos
            if (txtContrasena.text.length <=6){
                Toast.makeText(this, "Debe tener mas de 6 digitos", Toast.LENGTH_SHORT).show()
            }
            if (txtDUI.text.matches("[0-9]+-[0-9]".toRegex())
                && txtDUI.text.length <= 10){

            }
            if (txtNombre.text.matches("[a-zA-Z]".toRegex())){
                
            }
        }
    }
}
