alert("all Students")
var apiURL="http://localhost:8081/students";
fetch(apiURL) 
    // Handle success // Promise
    .then(response => response.json())  // convert to json
    .then(json => populateData(json))    //pass data to populateDate() OR print data to console
    .catch(err => console.log('Request Failed', err));
    
  function populateData(response){
	 var dataSection = document.getElementById('responseData');
	 dataSection.innerHTML='';
	 
	 for(i=0;i<response.length;i++){
		//alert(response[i].id)
		var idTag = document.createElement('h3');
   		 var data=response[i].id +"  "+response[i].name+"  "+response[i].age
   		 idTag.innerHTML=data;
   		  dataSection.appendChild(idTag);
	}
		
    
	 
}