package com.sist.vo;
/*
PRODUCT_NO         NUMBER
PRODUCT_NAME      VARCHAR2(100 BYTE)
PRODUCT_INTRO      VARCHAR2(200 BYTE)
PRODUCT_POSTER   VARCHAR2(300 BYTE)
PRICE                  NUMBER
SALE                     VARCHAR2(200 BYTE)
DELIVER               VARCHAR2(200 BYTE)
HIT                     NUMBER
CATEGORY            VARCHAR2(30 BYTE)
DETAIL_PAGE         VARCHAR2(1000 BYTE)
 */
public class ProductVO {
   private int no,hit;
   private String name,intro,poster,sale,deliver,category,price;
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }

   public String getPrice() {
      return price;
   }
   public void setPrice(String price) {
      this.price = price;
   }
   public int getHit() {
      return hit;
   }
   public void setHit(int hit) {
      this.hit = hit;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getIntro() {
      return intro;
   }
   public void setIntro(String intro) {
      this.intro = intro;
   }
   public String getPoster() {
      return poster;
   }
   public void setPoster(String poster) {
      this.poster = poster;
   }
   public String getSale() {
      return sale;
   }
   public void setSale(String sale) {
      this.sale = sale;
   }
   public String getDeliver() {
      return deliver;
   }
   public void setDeliver(String deliver) {
      this.deliver = deliver;
   }
   public String getCategory() {
      return category;
   }
   public void setCategory(String category) {
      this.category = category;
   }

   
}
