package com.outatime.personalform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.outatime.personalform.databinding.ActivityMainBinding
import com.outatime.personalform.databinding.ActivityShowInfoBinding
import kotlin.reflect.typeOf

class ShowInfo : AppCompatActivity() {

    private lateinit var binding2: ActivityShowInfoBinding
    //var myYear: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityShowInfoBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val bundle = intent.extras

        var name = bundle?.getString("name","")
        var birthday = bundle?.getString("birthday", "")
        var accountNumber = bundle?.getString("accountNumber","")
        var email = bundle?.getString("email","")
        var age = bundle?.getInt("age", 0)
        var myYear = bundle?.getInt("myYear", 0)
        age.toString()

        binding2.tvShowName.text = getString(R.string.tv_result_name, name)
        binding2.tvShowBirthday.text = getString(R.string.tv_result_birthday, birthday)
        binding2.tvShowAn.text = getString(R.string.tv_result_an, accountNumber)
        binding2.tvShowEmail.text = getString(R.string.tv_result_email, email)
        binding2.tvShowAge.text = getString(R.string.tv_result_age, age)

        if (myYear != null) {
            chineseHoroscope(myYear.toInt())
        }
        /*
        Toast.makeText(this, "Name: $name", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Birthday: $birthday", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Account number: $accountNumber", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Email: $email", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Age: $age", Toast.LENGTH_LONG).show()
         */

    }

    fun click(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun chineseHoroscope(year: Int) {
        if (year == 1924 || year == 1936 || year == 1948 || year == 1960 || year == 1972 || year == 1984 || year == 1996 || year == 2008 || year == 2020) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.rat)
            binding2.tvChineseHoroscopeType.text = getString(R.string.rat_chinese_horoscope)
        } else if (year == 1925 || year == 1937 || year == 1949 || year == 1961 || year == 1973 || year == 1985 || year == 1997 || year == 2009 || year == 2021) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.ox)
            binding2.tvChineseHoroscopeType.text = getString(R.string.ox_chinese_horoscope)
        } else if (year == 1926 || year == 1938 || year == 1950 || year == 1962 || year == 1974 || year == 1986 || year == 1998 || year == 2010 || year == 2022) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.tiger)
            binding2.tvChineseHoroscopeType.text = getString(R.string.tiger_chinese_horoscope)
        } else if (year == 1927 || year == 1939 || year == 1951 || year == 1963 || year == 1975 || year == 1987 || year == 1999 || year == 2011) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.rabbit)
            binding2.tvChineseHoroscopeType.text = getString(R.string.rabbit_chinese_horoscope)
        } else if (year == 1928 || year == 1940 || year == 1952 || year == 1964 || year == 1976 || year == 1988 || year == 2000 || year == 2012) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.dragon)
            binding2.tvChineseHoroscopeType.text = getString(R.string.dragon_chinese_horoscope)
        } else if (year == 1929 || year == 1941 || year == 1953 || year == 1965 || year == 1977 || year == 1989 || year == 2001 || year == 2013) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.snake)
            binding2.tvChineseHoroscopeType.text = getString(R.string.snake_chinese_horoscope)
        } else if (year == 1930 || year == 1942 || year == 1954 || year == 1966 || year == 1978 || year == 1990 || year == 2002 || year == 2014) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.horse)
            binding2.tvChineseHoroscopeType.text = getString(R.string.horse_chinese_horoscope)
        } else if (year == 1931 || year == 1943 || year == 1955 || year == 1967 || year == 1979 || year == 1991 || year == 2003 || year == 2015) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.goat)
            binding2.tvChineseHoroscopeType.text = getString(R.string.goat_chinese_horoscope)
        } else if (year == 1932 || year == 1944 || year == 1956 || year == 1968 || year == 1980 || year == 1992 || year == 2004 || year == 2016) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.monkey)
            binding2.tvChineseHoroscopeType.text = getString(R.string.monkey_chinese_horoscope)
        } else if (year == 1933 || year == 1945 || year == 1957 || year == 1969 || year == 1981 || year == 1993 || year == 2005 || year == 2017) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.rooster)
            binding2.tvChineseHoroscopeType.text = getString(R.string.rooster_chinese_horoscope)
        } else if (year == 1934 || year == 1946 || year == 1958 || year == 1970 || year == 1982 || year == 1994 || year == 2006 || year == 2018) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.dog)
            binding2.tvChineseHoroscopeType.text = getString(R.string.dog_chinese_horoscope)
        } else if (year == 1935 || year == 1947 || year == 1959 || year == 1971 || year == 1983 || year == 1995 || year == 2007 || year == 2019) {
            binding2.ivChineseHoroscope.setImageResource(R.drawable.pig)
            binding2.tvChineseHoroscopeType.text = getString(R.string.pig_chinese_horoscope)
        }
    }
}