package com.example.myapplication11.DATA.Model;

public class FragmentNavigateData {
    private String dataFromStartToList;
    private String dataFromStartToRecycler;
    public FragmentNavigateData(){
        this.dataFromStartToList = "Данные из StartFragment в ListFragment";
        this.dataFromStartToRecycler = "Данные из StartFragment в RecyclerFragment";
    }
    public String getDataFromStartToRecycler() {
        return dataFromStartToRecycler;
    }
    public void setDataFromStartToRecycler(String dataFromStartToRecycler) {
        this.dataFromStartToRecycler = dataFromStartToRecycler;
    }
    public void setDataFromStartToList(String dataFrom1to2) {
        this.dataFromStartToList = dataFromStartToList;
    }
    public String getDataFromStartToList() {
        return dataFromStartToList;
    }
}
