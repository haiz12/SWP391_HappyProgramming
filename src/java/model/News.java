/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trang
 */
public class News {

    
    int newsID;
    String Title, Content, ImageURL, PostDate;
   int eventday;
   String Monthdate;
   int Yeardate;
   String Summary;
    public News() {
    }

    public News(int newsID, String Title, String Content, String ImageURL, String PostDate, int eventday, String Monthdate, int Yeardate, String Summary) {
        this.newsID = newsID;
        this.Title = Title;
        this.Content = Content;
        this.ImageURL = ImageURL;
        this.PostDate = PostDate;
        this.eventday = eventday;
        this.Monthdate = Monthdate;
        this.Yeardate = Yeardate;
        this.Summary = Summary;
    }

    public News(String Title, String Content, String ImageURL, String PostDate, int eventday, String Monthdate, int Yeardate, String Summary) {
        this.Title = Title;
        this.Content = Content;
        this.ImageURL = ImageURL;
        this.PostDate = PostDate;
        this.eventday = eventday;
        this.Monthdate = Monthdate;
        this.Yeardate = Yeardate;
        this.Summary = Summary;
    }
    

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String PostDate) {
        this.PostDate = PostDate;
    }

    public int getEventday() {
        return eventday;
    }

    public void setEventday(int eventday) {
        this.eventday = eventday;
    }

    public String getMonthdate() {
        return Monthdate;
    }

    public void setMonthdate(String Monthdate) {
        this.Monthdate = Monthdate;
    }

    public int getYeardate() {
        return Yeardate;
    }

    public void setYeardate(int Yeardate) {
        this.Yeardate = Yeardate;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

    @Override
    public String toString() {
        return "News{" + "newsID=" + newsID + ", Title=" + Title + ", Content=" + Content + ", ImageURL=" + ImageURL + ", PostDate=" + PostDate + ", eventday=" + eventday + ", Monthdate=" + Monthdate + ", Yeardate=" + Yeardate + ", Summary=" + Summary + '}';
    }

   
   

    
    
  
}
