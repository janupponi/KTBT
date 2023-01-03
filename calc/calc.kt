import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }

        button_bracket_right.setOnClickListener{
            input.text = addToInputText(")")
        }

        button_0.setOnClickListener{
            input.text = addToInputText("0")
        }

        button_1.setOnClickListener{
            input.text = addToInputText("1")
        }

        button_2.setOnClickListener{
            input.text = addToInputText("2")
        }

        button_3.setOnClickListener{
            input.text = addToInputText("3")
        }

        button_4.setOnClickListener{
            input.text = addToInputText("4")
        }

        button_5.setOnClickListener{
            input.text = addToInputText("5")
        }

        button_6.setOnClickListener{
            input.text = addToInputText("6")
        }

        button_7.setOnClickListener{
            input.text = addToInputText("7")
        }

        button_8.setOnClickListener{
            input.text = addToInputText("8")
        }

        button_9.setOnClickListener{
            input.text = addToInputText("9")
        }

        button_dot.setOnClickListener{
            input.text = addToInputText(".")
        }

        button_division.setOnClickListener{
            input.text = addToInputText("/")
        }

        button_multiply.setOnClickListener{
            input.text = addToInputText("*")
        }

        button_addition.setOnClickListener{
            input.text = addToInputText("+")
        }

        button_subtraction.setOnClickListener{
            input.text = addToInputText("-")
        }

        button_equals.setOnClickListener{
            showResult()
        }
    }
    private fun addToInputText(buttonValue: String): String{
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.toString()
        return expression
    }

    private fun showResult(){
        try{
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else{
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }catch (e: Exception){
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}






//dependencies check
dependencies {

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.5.1'
    implementation 'com.google.android.material:material:1.7.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'org.mariuszgromada.math:MathParser.org-mXparser:4.4.2'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'
}
