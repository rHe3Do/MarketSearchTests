package steps;

import cucumber.api.Delimiter;
import cucumber.api.java.ru.Когда;
import pages.ExtendedFilterPage;
import pages.MainPage;
import pages.MarketPage;
import pages.ResultsPage;

import java.util.ArrayList;

public class ScenarioSteps {

    public MainPage mainPage = new MainPage();
    public MarketPage marketPage = new MarketPage();
    public ExtendedFilterPage extendedFilterPage = new ExtendedFilterPage();
    public ResultsPage resultsPage = new ResultsPage();

    @Когда("^осуществлен переход в Яндекс.([^\"]*)$")
    public void goToMarket(String category){
        mainPage.goToCat(category);
    }

    @Когда("^выбран подраздел \"([^\"]*)\" раздела Электроника")
    public void chooseSubCat(String cat){
        marketPage.chooseCat(cat);
    }

    @Когда("^осуществлен переход к расширенному поиску")
    public void extSearchSwitch(){
        marketPage.goToExtSearch();
    }

    @Когда("^задан параметр поиска стоимость от (\\d+) рублей")
    public void setMinPrice(Integer price){
        extendedFilterPage.setMinPriceSearch(price);
    }

    @Когда("^установлен фильтр по производителю: (.*)")
    public void chooseManufact(@Delimiter(" и ") ArrayList<String> company){
        extendedFilterPage.setFilter(company);
    }

    @Когда("^осуществлено нажатие на кнопку Показать результат")
    public void showResBtnClick(){
        extendedFilterPage.clickShowResultsBtn();
    }

    @Когда("^проверено, что отображено (\\d+) результатов")
    public void checkResAmount(Integer amount){
        resultsPage.checkElemetsAmount(amount);
    }

    @Когда("^сохранено название результата № (\\d+) и осуществлен новый поиск по этому названию")
    public void startNewSearch(Integer number){
        resultsPage.getElementTitle(number);
        resultsPage.startNewSearch();
    }

    @Когда("^проверено, что результат нового поиска соответствует сохраненному значению")
    public void compareTitles(){
        resultsPage.checkElementValue();
    }
}
