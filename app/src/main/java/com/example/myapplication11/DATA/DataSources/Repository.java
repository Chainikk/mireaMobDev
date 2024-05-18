package com.example.myapplication11.DATA.DataSources;

import android.content.Context;

import androidx.lifecycle.LiveData;
import com.example.myapplication11.DATA.DataSources.Files.AppSpecificDataSource;
import com.example.myapplication11.DATA.DataSources.Files.CommonFilesDataSource;
import com.example.myapplication11.DATA.DataSources.SP.SharedPreferencesDS;
import com.example.myapplication11.DATA.Model.Item;

import java.io.IOException;
import java.util.List;

public class Repository {
    private AppSpecificDataSource appSpecDataSource;
    private CommonFilesDataSource commonFilesDataSource;
    private SharedPreferencesDS LocalDS;
    public Repository(){}
    public Repository(Context context, String appSpecDSFileName){this.appSpecDataSource = new AppSpecificDataSource(context, appSpecDSFileName);}
    public Repository(Context context, String appSpecDSFileName, String commonFDSFileName){
        this.appSpecDataSource = new AppSpecificDataSource(context, appSpecDSFileName);
        this.commonFilesDataSource = new CommonFilesDataSource(context, commonFDSFileName);
    }
    public void writeAppSpecSD(String inputContent){appSpecDataSource.writeAppSpecificDS("\n" + inputContent);}
    public String readAppSpecDS(){return appSpecDataSource.readAppSpecificDS();}
    public boolean writeCommonFileDS(String inputContent) {return commonFilesDataSource.writeContent("\n" + inputContent);}
    public String readCommonFilesDS() {
        return commonFilesDataSource.readFile();
    }

    private DataSource dataSource = new LocalDataSource();
    public LiveData<List<Item>> getItems() {
        return dataSource.getItems();
    }
    public LiveData<Item> getItem(int itemId) {
        return dataSource.getItem(itemId);
    }
    public void createLocalDS(Context context) {
        if (LocalDS == null) {
            LocalDS = new SharedPreferencesDS(context);}
    }
    public String getLocalName() {
        if (LocalDS == null) return null;
        else return LocalDS.getString("Name");
    }
    public Integer getLocalImg() {
        if (LocalDS == null) return null;
        else return LocalDS.getInt("Img");
    }
    public void setLocalName(String name) {
        if (LocalDS == null) return;
        else LocalDS.writeString("Name", name);
    }
    public void setLocalImg(int img) {
        if (LocalDS == null) return;
        else LocalDS.writeInt("Img", img);}
    public Item getListItems() {
        if (LocalDS == null) return null;
        else return new Item(
                LocalDS.getInt("Img"),
                LocalDS.getString("Name")
        );
    }
}
