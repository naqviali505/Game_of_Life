//package com.company;
import BL.Board;
import java.lang.*;
public interface DBInterface
{
    public void delete_state(String Sname);
    public void savegameinfo(Board obj,String SName);
    public Board loadgameinfo(String Sname);
    public String viewstate();

}
