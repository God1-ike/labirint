   var canvas = document.getElementById("canvas"),
	ctx = canvas.getContext("2d"),
	canvasOffset = $("#canvas").offset(),
	offsetX = canvasOffset.left,
	offsetY = canvasOffset.top,
	rX = 0,
	rY = 0,
	mX = 0;
	mY = 0;
	canvas.height = 1000;
	canvas.width = 2000;
	var cWidth = canvas.width,
	cHeight = canvas.height,
	isDrag = false,
	isClicked = false,
	mIn = false;
	ctx.fillStyle = "rgb(244,244,244)";

	ctx.fillRect(rX,rY, 100, 100);
	/*
	*Ф-я обработчик нажатия мыши
	*@param e - event
	*@return null
	*/
	function mDown(e) {
		var xx = e.clientX - offsetX,
			yy = e.clientY - offsetY;
		if(((xx - rX <= 100) && (xx - rX >= 0)) && ((yy - rY >= 0) && (yy - rY <= 100))) {

			mX = xx;
			mY = yy;
			isDrag = true;
			mIn = true;
			isClicked = true;
		}
	}
	/*
	*Ф-я обработчик отпускания мыши
	*@param e - event
	*@return null
	*/
	function mUp(e) {
		if(mIn) {
			canMouseX = rX - mX + e.clientX - offsetX;
			canMouseY = rY - mY + e.clientY - offsetY;
			rX = rX - mX + e.clientX - offsetX;
			rY = rY - mY + e.clientY - offsetY;
			mIn = false;
			isClicked = false;
			dRect(e);
			ctx.font = "normal 12pt Arial ";
			var str = (rX - mX + e.clientX - offsetX) + "\n" + (rY - mY + e.clientY - offsetY);
			ctx.fillText(str, canMouseX + 110, canMouseY + 50);
		}
		isDrag = false;
	}
	/*
	*Ф-я обработчик выхода курсора из канваса
	*@param e - event
	*@return null
	*/
	function mOut(e) {
		if(isDrag) {
			rX = 0;
			rY = 0;
			mX = 0;
			mY = 0;
			isClicked = false;
			isDrag = false;
			canMouseX = 0;
			canMouseY = 0;
			dRect(e);
		}
	}
	/*
	*Ф-я отрисовки прямоугольника и текста
	*@param e - event
	*@return null
	*/
	function dRect(e) {
		ctx.clearRect(0, 0, cWidth, cHeight);
		ctx.fillRect(canMouseX, canMouseY, 100, 100);
		if(isClicked) {
			ctx.fillStyle = "rgb(" + (e.clientX % 255) + "," + ( e.clientY % 255) + ", 155)";
			ctx.font = "normal 12pt Arial ";
			var str = (rX - mX + e.clientX - offsetX) + "\n" + (rY - mY + e.clientY - offsetY);
			ctx.fillText(str, canMouseX + 110, canMouseY + 50);
		}
	}
	/*
	*Ф-я обработчик движения по канвасу
	*@param e - event
	*@return null
	*/
	function mMove(e) {
		canMouseX = rX - mX + e.clientX - offsetX;
		canMouseY = rY - mY + e.clientY - offsetY;
		if(isDrag) {
			dRect(e);
		}
	}
	$("#canvas").mousedown(function(e){mDown(e);});
	$("#canvas").mousemove(function(e){mMove(e);});
	$("#canvas").mouseup(function(e){mUp(e);});
	$("#canvas").mouseout(function(e){mOut(e);});



