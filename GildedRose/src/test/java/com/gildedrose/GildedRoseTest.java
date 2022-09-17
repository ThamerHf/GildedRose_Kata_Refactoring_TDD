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
  @DisplayName("Test that the quality and the sellIn for Sulfuras is unchanged")
  void testSulfuras(){
    Item element1 = new Item("Sulfuras, Hand of Ragnaros", 10, 20);
    Item element2 = new Item("Sulfuras, Hand of Ragnaros", -1, 20);
    GildedRose app = new GildedRose(new Item[] {element1, element2});
    app.updateQuality();

    assertThat("Quality is unchanged",element1.quality, is(20));
    assertThat("sellIn is unchanged", element1.sellIn, is(10));
    assertThat("Quality is unchanged",element1.quality, is(20));
    assertThat("sellIn is unchanged", element2.sellIn, is(-1));
 }

 @Test
 @DisplayName("Test that the quality of Aged Brie increase while it's SellIn decrease")
 void testAgedBrie(){
    Item element1 = new Item("Aged Brie", 6, 10);
    Item element2 = new Item("Aged Brie", -1, 10);
    Item element3 = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element1, element2, element3});
    app.updateQuality();

    assertThat("Quality must increase",element1.quality, is(11));
    assertThat("Quality must increase by 2 when sellIn < 0 and quality < 50",element2.quality, is(12));
    assertThat("Quality mustn't increase when sellIn < 0 and quality >= 50",element3.quality, is(50));
    
    assertThat("sellIn must decrease", element1.sellIn, is(5));
    assertThat("sellIn must decrease", element2.sellIn, is(-2));
    assertThat("sellIn must decrease", element3.sellIn, is(-2));
 }

 @Test
 @DisplayName("Test that the quality of Backstage passes increase while it's SellIn decrease")
 void testBackstagePasses(){
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 30, 10);
    Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
    Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10);
    Item element4 = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10);
    Item element5 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    Item element6 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49);
    GildedRose app = new GildedRose(new Item[] {element1, element2, element3, element4, element5, element6});
    app.updateQuality();

    assertThat("Quality must increase by 1 when sellIn >= 11",element1.quality, is(11));
    assertThat("Quality must increase by 2 when 5 < sellIn < 11",element2.quality, is(12));
    assertThat("Quality must increase by 3 when sellIn > 6",element3.quality, is(13));
    assertThat("Quality must decrease to 0 when sellIn < 0",element4.quality, is(0));
    assertThat("Quality must increase just by 1",element5.quality, is(50));
    assertThat("Quality must increase just by 1",element6.quality, is(50));

    assertThat("sellIn must decrease by 1",element1.sellIn, is(29));
    assertThat("sellIn must decrease by 1",element2.sellIn, is(9));
    assertThat("sellIn must decrease by 1",element3.sellIn, is(3));
    assertThat("sellIn must decrease by 1",element4.sellIn, is(-2));
    assertThat("sellIn must decrease by 1",element5.sellIn, is(9));
    assertThat("sellIn must decrease by 1",element6.sellIn, is(3));
 }

 @Test
 @DisplayName("Test for other product")
 void testOtherProduct(){
    Item element1 = new Item("P1", 30, 10);
    Item element2 = new Item("P2", -1, 10);
    Item element3 = new Item("P3", -1, 0);
    GildedRose app = new GildedRose(new Item[] {element1, element2, element3});
    app.updateQuality();

    assertThat("Quality must decrease by 1",element1.quality, is(9));
    assertThat("Quality must decrease by 2",element2.quality, is(8));
    assertThat("Quality mustn't decrease",element3.quality, is(0));

    assertThat("sellIn must decrease by 1", element2.sellIn, is(-2));
    assertThat("sellIn must decrease by 1", element1.sellIn, is(29));
    assertThat("sellIn must decrease by 1", element3.sellIn, is(-2));
 }

}