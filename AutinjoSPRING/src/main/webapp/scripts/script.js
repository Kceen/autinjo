var audiModels = ["1", "2", "3"];
var mbModels = ["4", "5", "6"];
var newOption; 

var getBrand = function() {
	var allBrandsSelect = document.getElementById("marka");
	var allBrandsOptions = document.getElementById("marka").options;
	var selectedBrandIndex = allBrandsOptions.selectedIndex;
	var marka = allBrandsOptions[selectedBrandIndex].text;

	
	var allModelsSelect = document.getElementById("model");
	console.log(audiModels);

	if(marka == "Audi") {
		for (var i = allModelsSelect.length; i > 0; i--) {
			allModelsSelect.remove(i)
		}

		for (var i = 0; i < audiModels.length; i++) {
			newOption = document.createElement("option");
			newOption.text = audiModels[i];
			allModelsSelect.add(newOption);
		}
	}

	if(marka == "Mercedes Benz") {
		for (var i = allModelsSelect.length; i > 0; i--) {
			allModelsSelect.remove(i)
		}

		for (var i = 0; i < mbModels.length; i++) {
			newOption = document.createElement("option");
			newOption.text = mbModels[i];
			allModelsSelect.add(newOption);
		}
	}

	console.log(marka);
}