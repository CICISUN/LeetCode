var data;
$(document).ready(function () {
    var data1={
              "Products": [
                {
                  "prod_id": "10103",
                  "title": "Leather Brogue Ankle-Strap Sandal",
                  "price": "$850.00"
                },
                {
                  "prod_id": "10102",
                  "title": "Simple Patent Red Sole Pump, Black",
                  "price": "$795.00",
                  "sale_price": "$101.00"
                },
                {
                  "prod_id": "10101",
                  "title": "Mini Miller Leather Logo Pump, with black perforated leather, 3.3in covered heel & Brogue detailing",
                  "price": "$495.00",
                  "sale_price": "$395.00"
                },
                {
                  "prod_id": "10104",
                  "title": "Asymmetric Zip Wedge Boot, Navy",
                  "price": "$695.00",
                  "sale_price": "$202.00"
                },
                {
                  "prod_id": "10105",
                  "title": "Riddlestone Check-Panel Rain Boot",
                  "price": "$325.00"
                },
                {
                  "prod_id": "10107",
                  "title": "Soleil Mini Zip Crossbody Bag, Cuoio"
                },
                {
                  "prod_id": "10106",
                  "title": "Classic City Bag, Blue",
                  "sale_price": "$245.00"
                }
              ]
            };
    var data2={
              "10101": {
                "brand": "Tory Burch",
                "img_url": "http://images.neimanmarcus.com/ca/2/product_assets/X/2/T/A/G/NMX2TAG_mk.jpg"
              },
              "10102": {
                "brand": "Christian Louboutin",
                "img_url": "http://images.neimanmarcus.com/ca/1/product_assets/X/2/S/Q/8/NMX2SQ8_mk.jpg"
              },
              "10103": {
                "brand": "Gucci",
                "img_url": "http://images.neimanmarcus.com/ca/2/product_assets/X/2/Q/R/5/NMX2QR5_mk.jpg"
              },
              "10104": {
                "brand": "Alexander McQueen",
                "img_url": "http://images.neimanmarcus.com/ca/2/product_assets/X/2/R/L/N/NMX2RLN_mk.jpg"
              },
              "10105": {
                "brand": "Burberry",
                "img_url": "http://images.neimanmarcus.com/ca/1/product_assets/X/2/V/1/Z/NMX2V1Z_mk.jpg"
              },
              "10107": {
                "brand": "3.1 Phillip Lim",
                "img_url": "http://images.neimanmarcus.com/ca/3/product_assets/V/2/J/N/N/NMV2JNN_mz.jpg"
              }
            }; 
    //parse data         
    data = prepareData(data1,data2);
    //process data
    var e = document.getElementById("colselect");
    var colnum = e.options[e.selectedIndex].value;
    var extra = data.length % colnum;
    if(extra!=0) var rownum = parseInt(data.length / colnum) + 1;
    else var rownum = parseInt(data.length / colnum);
    //draw data
    drawData(data, rownum, colnum);
    //changecol
    $('#colselect').change(changecol);
    //sort
    $('#sortselect').change(changesort);
});

function changesort(){
    var e = document.getElementById("sortselect");
    var val = e.options[e.selectedIndex].value;
    if(val == 'price'){
        data = data.sort(compareprice);
        console.log(data);
    }
    else if(val == 'sale'){
        data = data.sort(comparesaleprice);
        console.log(data);
    }
    changecol();
}

function compareprice(a,b) {
  if ((a['price'] < b['price']) || !('price' in a))
    return -1;
  if ((a['price'] > b['price']) || !('price' in b))
    return 1;
  return 0;
}

function comparesaleprice(a,b) {
  if ((a['sale_price'] < b['sale_price']) || !('sale_price' in a))
    return -1;
  if ((a['sale_price'] > b['sale_price']) || !('sale_price' in b))
    return 1;
  return 0;
}



function changecol(){
    var e = document.getElementById("colselect");
    var colnum = e.options[e.selectedIndex].value;
    var extra = data.length % colnum;
    if(extra!=0) var rownum = parseInt(data.length / colnum) + 1;
    else var rownum = parseInt(data.length / colnum);
    //empty data
    $("#datagrid").empty();
    //draw data
    drawData(data, rownum, colnum);    
}



function drawData(data, rownum, colnum){
    for(var i=0; i<rownum; i++){
        var row = $("<tr></tr>")
        $("#datagrid").append(row); 
        for(var j=0; j<colnum; j++){
            var itemid=i*colnum + j;
            if(!data[itemid]){
            //if(itemid > data.length -1){
                row.append($("<td></td>"));
                row.find('td:last').width(1/colnum + "%");
                row.find('td:last').append($("<div class='item'></div>"));
            }
            else{
                row.append($("<td></td>"));
                row.find('td:last').width(1/colnum + "%");
                row.find('td:last').append($("<div class='item'></div>"));

                if("img_url" in data[itemid]){
                    row.find('td:last').find('div').append($("<img src=" + data[itemid]["img_url"] + ">"));
                }
                else{
                    row.find('td:last').find('div').append($("<img src=data:image/jpeg;base64,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>"));
                }
                if("brand" in data[itemid]){
                    row.find('td:last').find('div').append($("<h3>" + data[itemid]["brand"] + "</h3><br>"));
                }

                row.find('td:last').find('div').append($("<h4>" + data[itemid]["title"] + "</h4><br>"));
                if('price' in data[itemid]){
                    row.find('td:last').find('div').append($("<p>" + data[itemid]["price"] + "</p>"));
                }
                else{
                    row.find('td:last').find('div').append($("<p>Coming Soon</p>"));
                }
                if('sale_price' in data[itemid]){
                    row.find('td:last').find('div').append($("<p class='saleprice'>" + data[itemid]["sale_price"] + "</p>"));
                }
            }
        }
    }
}

function prepareData(data1, data2) {
    // $.getJSON("data1.json", function(json1) {
    //     console.log(json1); 
    // });
    // $.getJSON("data2.json", function(json2) {
    //     console.log(json2); 
    // });
    var data=[];
    for(var i=0;i<data1["Products"].length;i++){
        item={};
        item["prod_id"] = data1["Products"][i]['prod_id'];
        item["title"] = data1["Products"][i]['title'];
        // item['price'] = 9999999;
        if('price' in data1["Products"][i]){
            item['price'] = data1["Products"][i]['price'];
        }
        // item['sale_price'] =;
        if('sale_price' in data1["Products"][i]){
            item['sale_price'] = data1["Products"][i]['sale_price'];
        }
        if(item["prod_id"] in data2){
            item['brand'] = data2[item["prod_id"]]["brand"];
            item['img_url'] = data2[item["prod_id"]][["img_url"]];
        }
        data.push(item);        
    };
    return data;
};

