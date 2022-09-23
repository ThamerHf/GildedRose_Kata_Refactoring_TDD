package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test that the quality and the sellIn for Sulfuras is unchanged for a sellIn value >= 0")
  void testSulfuras1(){
    Item element1 = new Item("Sulfuras, Hand of Ragnaros", 10, 20);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality is unchanged",element1.quality, is(20));
    assertThat("sellIn is unchanged", element1.sellIn, is(10));
 }

 @Test
 @DisplayName("Test that the quality and the sellIn for Sulfuras is unchanged for a sellIn value < 0")
 void testSulfuras2(){
   Item element1 = new Item("Sulfuras, Hand of Ragnaros", -1, 20);
   GildedRose app = new GildedRose(new Item[] {element1});
   app.updateQuality();

   assertThat("Quality is unchanged",element1.quality, is(20));
   assertThat("sellIn is unchanged", element1.sellIn, is(-1));
}


 @Test
 @DisplayName("Test that the quality (quality < 50) of Aged Brie increase by 1 while its SellIn (sellIn >= 0) decrease")
 void testAgedBrie1(){
    Item element1 = new Item("Aged Brie", 6, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase by 1",element1.quality, is(11));
    assertThat("sellIn must decrease", element1.sellIn, is(5));
 }

 @Test
 @DisplayName("Test that the quality (quality < 49) of Aged Brie increase by 2 while its SellIn (sellIn < 0) decrease")
 void testAgedBrie2(){
    Item element1 = new Item("Aged Brie", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase by 2 when sellIn < 0 and quality < 50",element1.quality, is(12));    
    assertThat("sellIn must decrease", element1.sellIn, is(-2));
 }

 @Test
 @DisplayName("Test that the quality (quality >= 50) of Aged Brie is unchanged while its SellIn (sellIn < 0) decrease")
 void testAgedBrie3(){
    Item element1 = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality mustn't increase when sellIn < 0 and quality >= 50",element1.quality, is(50));
    assertThat("sellIn must decrease", element1.sellIn, is(-2));
 }

 @Test
 @DisplayName("Test that the quality (quality >= 50) of Aged Brie is unchanged while its SellIn (sellIn >= 0) decrease")
 void testAgedBrie4(){
    Item element1 = new Item("Aged Brie", 3, 50);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality mustn't increase when sellIn < 0 and quality >= 50",element1.quality, is(50));
    assertThat("sellIn must decrease", element1.sellIn, is(2));
 }

 @Test
 @DisplayName("Test that the quality (quality == 49) of Aged Brie increase by 1 while its SellIn (sellIn < 0) decrease")
 void testAgedBrie5(){
    Item element1 = new Item("Aged Brie", -1, 49);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase by 2 when sellIn < 0 and quality == 49",element1.quality, is(50));    
    assertThat("sellIn must decrease", element1.sellIn, is(-2));
 }

 @Test
 @DisplayName("Test that the quality (quality<49) of Backstage passes increase by 1 while its SellIn (5<sellIn<11) decrease")
 void testBackstagePasses1(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 30, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase by 1 when sellIn >= 11",element1.quality, is(11));
    assertThat("sellIn must decrease by 1",element1.sellIn, is(29));
 }

 @Test
 @DisplayName("Test that the quality (quality<49) of Backstage passes increase by 2 while its SellIn (5<sellIn<11) decrease")
 void testBackstagePasses2(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase by 2 when 5 < sellIn < 11",element1.quality, is(12));
    assertThat("sellIn must decrease by 1",element1.sellIn, is(9));
 }

 @Test
 @DisplayName("Test that the quality (quality<49) Backstage passes increase while its SellIn (0<sellIn<6) decrease")
 void testBackstagePasses3(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase by 3 when 0<sellIn<6",element1.quality, is(13));
    assertThat("sellIn must decrease by 1",element1.sellIn, is(3));
 }

 @Test
 @DisplayName("Test that the quality of Backstage passes decrease to 0 while its SellIn (sellIn<0) decrease")
 void testBackstagePasses4(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must decrease to 0 when sellIn < 0",element1.quality, is(0));
    assertThat("sellIn must decrease by 1",element1.sellIn, is(-2));
 }

 @Test
 @DisplayName("Test that the quality (quality == 49) of Backstage passes increase while it's SellIn (0<sellIn<11) decrease")
 void testBackstagePasses5(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase just by 1",element1.quality, is(50));
    assertThat("sellIn must decrease by 1",element1.sellIn, is(9));
 }

 @Test
 @DisplayName("Test that the quality (quality == 49) of Backstage passes increase while it's SellIn (0<sellIn<6) decrease")
 void testBackstagePasses6(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase just by 1",element1.quality, is(50));
    assertThat("sellIn must decrease by 1",element1.sellIn, is(3));
 }

 @Test
 @DisplayName("Test that the quality (quality >= 50) of Backstage passes is unchanged while it's SellIn decrease")
 void testBackstagePasses7(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must increase just by 1",element1.quality, is(50));
    assertThat("sellIn must decrease by 1",element1.sellIn, is(3));
 }


 @Test
 @DisplayName("Test for other product while sellIn > 0 decrese, 50>quality>0 increase by 1")
 void testOtherProduct1(){
    Item element1 = new Item("P1", 30, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must decrease by 1",element1.quality, is(9));
    assertThat("sellIn must decrease by 1", element1.sellIn, is(29));
 }

 @Test
 @DisplayName("Test for other product while sellIn > 0 decrese, 50>quality>0 decrease by 2")
 void testOtherProduct2(){
    Item element1 = new Item("P2", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must decrease by 2",element1.quality, is(8));
    assertThat("sellIn must decrease by 1", element1.sellIn, is(-2));
 }

 @Test
 @DisplayName("Test for other product while sellIn < 0 decrese, quality == 1 decrease by 1")
 void testOtherProduct3(){
    Item element1 = new Item("P2", -1, 1);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality must decrease by 2",element1.quality, is(0));
    assertThat("sellIn must decrease by 1", element1.sellIn, is(-2));
 }

 @Test
 @DisplayName("Test for other product while sellIn decrease, quality == 0 still unchanged")
 void testOtherProduct4(){
    Item element1 = new Item("P3", -1, 0);
    GildedRose app = new GildedRose(new Item[] {element1});
    app.updateQuality();

    assertThat("Quality mustn't decrease",element1.quality, is(0));
    assertThat("sellIn must decrease by 1", element1.sellIn, is(-2));
 }

}