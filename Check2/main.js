function changeLang() {
    var selectBox = document.getElementById("selectLanguages");
    var selectedValue = selectBox.value;
    var jp= document.querySelector("table tr:nth-child(1)");
    var en= document.querySelector("table tr:nth-child(2)");

    if (selectedValue === "jpn") {
        jp.style.display = "table-row";
        en.style.display = "none";
    } else if (selectedValue === "en") {
        jp.style.display = "none";
        en.style.display = "table-row";
    } else if (selectedValue === "all") {
        jp.style.display = "table-row";
        en.style.display = "table-row";
    } else {
        jp.style.display = "none";
        en.style.display = "none";
    }
}
