package org.ntutssl.library;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ItemParser 
{
    private ItemBuilder ib;

    public ItemParser() 
    {
        ib = new ItemBuilder();
    }


    public void parseItem(String jsonString) 
    {
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonString).getAsJsonObject();
        if("book".equals(jsonObject.get("type").getAsString()))
        {
            ib.buildBook(jsonObject.get("name").getAsString(),
                jsonObject.get("description").getAsString(),
                jsonObject.get("author").getAsString(),
                jsonObject.get("isbn").getAsString());
        }
        else if("collection".equals(jsonObject.get("type").getAsString()))
        {
            ib.beginBuildCollection(jsonObject.get("name").getAsString(), jsonObject.get("description").getAsString());
            Integer itemSize = jsonParser.parse(jsonString).getAsJsonObject().getAsJsonArray("items").size();
            for(int i = 0; i < itemSize; i++)
            {
                JsonObject jsonitem = jsonParser.parse(jsonString).getAsJsonObject().getAsJsonArray("items").get(i).getAsJsonObject();
                String currentItemString = gson.toJson(jsonitem);
                parseItem(currentItemString);
            }
            ib.endBuildCollection();
        }
        else
        {}
    }

    public Item getResult() 
    {
		return ib.getResult();
    }
}