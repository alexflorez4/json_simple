package Reader;

/**
 * JSON Notes:
 *
 * Data is in name/value pairs
 * Data is separated by commas
 * Curly braces hold objects
 * Square brackets hold arrays
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader
{
    public static void main(String[] args) throws FileNotFoundException
    {

        String file = "C:/Users/alexf/Documents/FAU/JavaProjects/JSON_Test/src/Reader/Browse_GetItem_areatrend.json";

        JSONArray inputData = null;
        JSONParser parser = new JSONParser();

        List<String > myList = new ArrayList<>();

        try
        {
            JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
            inputData = (JSONArray) obj.get("itemSummaries");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        String price = "";
        String curr = "";

        for (int i=0; i<2; i++)
        {

            JSONObject item = (JSONObject) inputData.get(i);
            JSONObject priceObj = (JSONObject) item.getOrDefault("price", "");

            //System.out.println(item);
            //System.out.println("Price Object" + priceObj);
            for (int j=0; j<2; j++)
            {
               price = (String)priceObj.get("value");
                curr = (String) priceObj.get("currency");
            }

            String itemid = (String) item.get("itemId");
            myList.add(itemid);
        }

        for (String items: myList )
        {
            System.out.println(items + " " + price + " " + curr);
        }
    }
}
