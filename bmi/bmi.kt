class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightpicker.maxValue = 150
        binding.weightpicker.minValue = 30

        binding.heightpicker.maxValue = 250
        binding.heightpicker.minValue = 100

        binding.weightpicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }

        binding.heightpicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }

    }

    private fun calculateBMI()
        {
            val height = binding.heightpicker.value
            val doubleHeight = height.toDouble()/100

            val weight = binding.weightpicker.value

            val bmi = weight.toDouble()/(doubleHeight * doubleHeight)

            binding.result.text = String.format("Your BMI is %.2f", bmi)
        }
    }
