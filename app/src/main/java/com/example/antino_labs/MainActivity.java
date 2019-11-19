package com.example.antino_labs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.antino_labs.Adapters.Contact;
import com.example.antino_labs.Adapters.ContactAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String JSON;
    Contact[] contacts;
    RecyclerView recyclerView;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_card);
        new JsonTask().execute("http://demo8716682.mockable.io/cardData");
    }



    private class JsonTask extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try{
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection)url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    //Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {
                if(connection!=null)
                    connection.disconnect();
                try
                {
                    if(reader!=null) reader.close();
                }catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSON=s;
            System.out.println(JSON);
            try{
                JSONArray array = new JSONArray(JSON);
                //Log.e("TAg",array.length()+"");
                contacts = new Contact[array.length()];
                for(int i=0;i<array.length();i++)
                {
                    JSONObject object  = array.getJSONObject(i);
                    contacts[i] = new Contact(object.get("url")+"",object.get("name")+"",object.get("age")+"",object.get("location")+"",object.get("bodyType")+"",object.get("userDesire")+"");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            adapter = new ContactAdapter(contacts,getApplication());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        }

    }

}
