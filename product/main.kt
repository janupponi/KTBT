lass MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mobile = findViewById<ImageView>(R.id.mobile)
        val headphone = findViewById<ImageView>(R.id.headphone)
        val charger = findViewById<ImageView>(R.id.charger)
        val earphone = findViewById<ImageView>(R.id.earphone)

        mobile.setOnClickListener{
            val intent = Intent( this, mobilee::class.java)
            startActivity(intent)
        }

        headphone.setOnClickListener{
            val intent = Intent( this, com.example.productdisplayapp.headphone::class.java)
            startActivity(intent)
        }

        charger.setOnClickListener{
            val intent = Intent( this, com.example.productdisplayapp.charger::class.java)
            startActivity(intent)
        }

        earphone.setOnClickListener{
            val intent = Intent( this, com.example.productdisplayapp.earphone::class.java)
            startActivity(intent)
        }
    }
}
