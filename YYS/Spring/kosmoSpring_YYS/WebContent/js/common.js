

function comma(s){
	let result = s.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	console.log(result);
	return result;
}


function comma_replace(s){
	let result = s.toString().replace(/,/g, "");
	console.log(result);
	return result;
}