package com.sargent.mark.populararticles;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.sargent.mark.populararticles.data.Article;
import com.sargent.mark.populararticles.data.DBHelper;
import com.sargent.mark.populararticles.data.DatabaseUtils;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.support.v4.app.ActivityCompat.requestPermissions;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleInstrumentedTest {
    ArrayList<Article> articles;

    @Before
    public void setup() throws JSONException {
        String JSON = "{\n" +
                "\t\"status\": \"OK\",\n" +
                "\t\"copyright\": \"Copyright (c) 2017 The New York Times Company.  All Rights Reserved.\",\n" +
                "\t\"num_results\": 325,\n" +
                "\t\"results\": [{\n" +
                "\t\t\"url\": \"https:\\/\\/www.nytimes.com\\/2017\\/07\\/10\\/us\\/politics\\/donald-trump-jr-russia-email-candidacy.html\",\n" +
                "\t\t\"adx_keywords\": \"Russian Interference in 2016 US Elections and Ties to Trump Associates;Trump, Donald J Jr;United States Politics and Government;Clinton, Hillary Rodham;Presidential Election of 2016;Goldstone, Rob (Publicist);Veselnitskaya, Natalia;Agalarov, Emin;Trump, Donald J\",\n" +
                "\t\t\"column\": \"\",\n" +
                "\t\t\"section\": \"U.S.\",\n" +
                "\t\t\"byline\": \"By MATT APUZZO, JO BECKER, ADAM GOLDMAN and MAGGIE HABERMAN\",\n" +
                "\t\t\"type\": \"Article\",\n" +
                "\t\t\"title\": \"Trump Jr. Was Told in Email of Russian Effort to Aid Campaign\",\n" +
                "\t\t\"abstract\": \"The president\\u2019s son was told in an email that the Russian government wanted to help Donald J. Trump\\u2019s election bid last year.\",\n" +
                "\t\t\"published_date\": \"2017-07-10\",\n" +
                "\t\t\"source\": \"The New York Times\",\n" +
                "\t\t\"id\": 100000005249441,\n" +
                "\t\t\"asset_id\": 100000005249441,\n" +
                "\t\t\"views\": 1,\n" +
                "\t\t\"des_facet\": [\"RUSSIAN INTERFERENCE IN 2016 US ELECTIONS AND TIES TO TRUMP ASSOCIATES\", \"UNITED STATES POLITICS AND GOVERNMENT\", \"PRESIDENTIAL ELECTION OF 2016\"],\n" +
                "\t\t\"org_facet\": \"\",\n" +
                "\t\t\"per_facet\": [\"TRUMP, DONALD J JR\", \"CLINTON, HILLARY RODHAM\", \"GOLDSTONE, ROB (PUBLICIST)\", \"VESELNITSKAYA, NATALIA\", \"AGALAROV, EMIN\", \"TRUMP, DONALD J\"],\n" +
                "\t\t\"geo_facet\": \"\",\n" +
                "\t\t\"media\": [{\n" +
                "\t\t\t\"type\": \"image\",\n" +
                "\t\t\t\"subtype\": \"photo\",\n" +
                "\t\t\t\"caption\": \"Donald Trump Jr. at a rally in Bozeman, Mont., in May.\",\n" +
                "\t\t\t\"copyright\": \"William Campbell\\/Corbis, via Getty Images\",\n" +
                "\t\t\t\"approved_for_syndication\": 1,\n" +
                "\t\t\t\"media-metadata\": [{\n" +
                "\t\t\t\t\"url\": \"https:\\/\\/static01.nyt.com\\/images\\/2017\\/07\\/11\\/us\\/11dc-trumpmeeting-1\\/11dc-trumpmeeting-1-thumbStandard.jpg\",\n" +
                "\t\t\t\t\"format\": \"Standard Thumbnail\",\n" +
                "\t\t\t\t\"height\": 75,\n" +
                "\t\t\t\t\"width\": 75\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"url\": \"https:\\/\\/static01.nyt.com\\/images\\/2017\\/07\\/11\\/us\\/11dc-trumpmeeting-1\\/11dc-trumpmeeting-1-mediumThreeByTwo210.jpg\",\n" +
                "\t\t\t\t\"format\": \"mediumThreeByTwo210\",\n" +
                "\t\t\t\t\"height\": 140,\n" +
                "\t\t\t\t\"width\": 210\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"url\": \"https:\\/\\/static01.nyt.com\\/images\\/2017\\/07\\/11\\/us\\/11dc-trumpmeeting-1\\/11dc-trumpmeeting-1-mediumThreeByTwo440.jpg\",\n" +
                "\t\t\t\t\"format\": \"mediumThreeByTwo440\",\n" +
                "\t\t\t\t\"height\": 293,\n" +
                "\t\t\t\t\"width\": 440\n" +
                "\t\t\t}]\n" +
                "\t\t}]\n" +
                "\t}]}";

        articles = NetworkUtils.parseJSON(JSON);

    }

    @Test
    public void testJSONParsingNotNull() throws Exception {
        assert (articles != null);
    }

    @Test
    public void testJSONParsingNotEmpty() {
        assert (articles.size() > 0);
    }

    @Test
    public void testJSONParsingDate(){
        assert (articles.get(0).getPublished_date().equals("2017-07-10"));
    }

    @Test
    public void checkDBPath(){
        File dbFile = InstrumentationRegistry.getContext().getDatabasePath("articles.db");

        assert(dbFile.exists());
    }

    @Test
    public void testDBInsertAndRetrieve(){

        DBHelper helper = new DBHelper(InstrumentationRegistry.getTargetContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        DatabaseUtils.deleteAll(db);
        DatabaseUtils.bulkInsert(db, articles);
        Cursor cursor = DatabaseUtils.getAll(db);
        Log.d("mytest", "cursor count " + cursor.getCount());
        assert(cursor.getCount() > 0);

        db.close();
        cursor.close();
    }
}
