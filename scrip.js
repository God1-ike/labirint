/*
*function razdel(mass)
*
*@param mass - строка
*
* разделяет сроку на элементы ( парсит по знакам";" и ",")
*
*@return mass - массив элементов
*/
function razdel(mass)
{
	mass = mass.split(";");
		for(var i = 0; i < mass.length; i++)
		{
			mass[i] = mass[i].split(",");	
		}
	return mass;
}

/*
*function prov(scores1, scores2, ratio)
*
*@param scores1 - первое множество
*@param scores2 - второе множество
*@param ratio - отношение
*
* проверяет принадлежат ли элементы отношения к множествам
*
*@return 2 - если элементы не принадлежат множествам
*@return 1 - если элементы принадлежат множествам
*/
function prov(scores1, scores2, ratio) {
	var kontr2;
	for(var i = 0; i < ratio.length; i++) {
		kontr2 = 0;
		
		for (var k = 0; k < scores1.length; k++) 
			if (ratio[i][0] == scores1[k])	
				kontr2++;
		
		if (kontr2 == 0){
			return 2;
		}
	}	
	for(var i = 0; i < ratio.length; i++) {
		kontr2 = 0;		
		for (var k = 0; k < scores2.length; k++) 
			if (ratio[i][1] == scores2[k])
				kontr2++;
		
		if (kontr2 == 0){
			return 2;
		}
	}
	return 1;
}
/*
*function nafunc(scores1, scores2, ratio)
*
*@param scores1 - первое множество
*@param scores2 - второе множество
*@param ratio - отношение
*
* проверяет отношение на свойство функции
*
*@return false - если входные данные не являются функцией
*@return true - если входные данные являются функцией
*/
function nafunc(scores1, scores2, ratio) {
	var mC = [];
	
	for(var i = 0; i < ratio.length; i++) {
		for(var j = 0; j < scores1.length; j++) {
			if(ratio[i][0] == scores1[j]) {
				for (var k = 0; k < mC.length; k++) 
					if (ratio[i][0] == mC[k]){
						return false;
					}	
				mC.push(ratio[i][0]); 	
			}
		}
	}
	return true;
}



/*
*function union()
*
*запускается по клику на кнопку
*считывает данные и отправляет их по функциям 
*
*@return false - если входные данные признаны невалидными фун-ей check()
*/
function union(){
	document.getElementById("result").innerHTML = "";
	var scores1 = document.getElementById("scores1").value;
	scores1 = scores1.split(",");
	var scores2 = document.getElementById("scores2").value;
	scores2 = scores2.split(",");
	var ratio = document.getElementById("ratio").value;
	ratio = razdel(ratio);
	var check = null;
	
	var prover = prov(scores1, scores2, ratio);
	if (prover == 2) {
		document.getElementById("result").innerHTML += "В отношении есть элементы не принадлежащие множеству";
	} else {
		check = nafunc(scores1, scores2, ratio);
	}
	
	if (check == true){
		document.getElementById("result").innerHTML += "Отношение является функцией";
	} else if(check == null) {
		document.getElementById("result").innerHTML += "";
	} else {
		document.getElementById("result").innerHTML += "Отношение Не является функцией";
	}
	
}