<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>messagerie</title>
    <link rel="stylesheet" type="text/css" href="../public/css/messagerie.css">
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
	<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous">
	
	</script>

    <script src="../public/js/header.js"></script>
    
    <script type="text/javascript">

        window.onload = function(){
            var Words = document.getElementById("words");
            var Who = document.getElementById("who");
            var TalkWords = document.getElementById("talkwords");
            var TalkSub = document.getElementById("talksub");
            var TalkSubStockRempli = document.getElementById("stockrempli");
            var TalkSubCommandePrete = document.getElementById("commandeprete");

            //when user clicked "Stock rempli" button, system send a short sentence automatically
            TalkSubStockRempli.onclick = function(){
            	str = '<div class="btalk"><span>B : Stock rempli</span></div>' ;
                Words.innerHTML = Words.innerHTML + str;
            }
            
          	//when user clicked "Commande prête" button
            TalkSubCommandePrete.onclick = function(){
            	str = '<div class="btalk"><span>B : Command prête</span></div>' ;
                Words.innerHTML = Words.innerHTML + str;
            }
            
            TalkSub.onclick = function(){
	            //Define an empty string
                var str = "";
                if(TalkWords.value == ""){
	                 // show alert window when input box is empty
                    alert("Veuillez entrer du texte");
                    return;
                }
                
                //when user inputed message and click send button 
                str = '<div class="btalk"><span>B :' + TalkWords.value +'</span></div>' ;
                Words.innerHTML = Words.innerHTML + str;
                
                /*
                if(Who.value == 0){
	                //if Who.value = 0 so people A talk
                    str = '<div class="atalk"><span>A :' + TalkWords.value +'</span></div>';
                }
                else{
                    str = '<div class="btalk"><span>B :' + TalkWords.value +'</span></div>' ;  
                }
               
                Words.innerHTML = Words.innerHTML + str;
                */
            }
        }
    </script>
</head>
<body onload="includeHeaderAndCheckUser()">
<input id="checkSession" type="text" name="checkSession" value ="${sessionScope.type}" hidden>

	<div id="includedHeader"></div>
    <div class="talk_con">
        <div class="talk_show" id="words">
            <div class="atalk"><span id="asay">A：Bonjour</span></div>
       		<div class="btalk"><span id="bsay">B: Bonjour</span></div>   
        </div>
        
        <div class="talk_short_input">
        	<input type="button" value="Stock remplir" class="stock_rempli" id="stockrempli">
        	<input type="button" value="Commande prête" class="commande_prete" id="commandeprete">
        </div>
        
        <div class="talk_input">
            
            <!--
            <select class="whotalk" id="who">
                <option value="0">A：</option>
                <option value="1">B：</option>
            </select>-->
            
            <input type="text" class="talk_word" id="talkwords">
            <input type="button" value="envoyer" class="talk_sub" id="talksub">
        </div>
    </div>
    <div id="includedFooter"></div>

</body>
</html>