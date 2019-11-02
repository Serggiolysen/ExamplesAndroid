package com.lysenko.xmlParser

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lysenko.R
import org.xmlpull.v1.XmlPullParser

class MainActivityXmlParse : AppCompatActivity() {

    val LOG_TAG = "LOGG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_xml_parse)

        val xpp = resources.getXml(R.xml.data)

        while (xpp.eventType != XmlPullParser.END_DOCUMENT) {
            when (xpp.eventType) {
                // начало документа
                XmlPullParser.START_DOCUMENT -> Log.d(LOG_TAG, "START_DOCUMENT")
                // начало тэга
                XmlPullParser.START_TAG -> {
                    Log.d(LOG_TAG, "START_TAG: name = " + xpp.name
                                + ", depth = " + xpp.depth + ", attrCount = "
                                + xpp.attributeCount)
                    var tmp = ""
                    for (i in 0 until xpp.attributeCount) {
                        tmp = (tmp + xpp.getAttributeName(i) + " = "
                                + xpp.getAttributeValue(i) + ", ")
                    }
                    if (!TextUtils.isEmpty(tmp))
                        Log.d(LOG_TAG, "Attributes: $tmp")
                }
                // конец тэга
                XmlPullParser.END_TAG -> Log.d(LOG_TAG, "END_TAG: name = " + xpp.getName())
                // содержимое тэга
                XmlPullParser.TEXT -> Log.d(LOG_TAG, "text = " + xpp.getText())

                else -> {
                }
            }
            // следующий элемент
            xpp.next()
        }
        Log.d(LOG_TAG, "END_DOCUMENT")
    }
}
