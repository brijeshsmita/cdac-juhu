function validateForm() {
	//fetching the name of the form
    var x = document.forms["myForm"]["fname"].value;
    if (x==null || x=="") {
        alert("First name must be filled out");
        return false;        
    }
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (x==null || x=="") {
        alert("Email must be filled out");        
        return false;
    }else if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
    	alert("Not a valid e-mail address");
    	 return false;
    }
    if( document.myForm.Zip.value == "" ||
            isNaN( document.myForm.Zip.value) ||
            document.myForm.Zip.value.length != 6 )
    {
      alert( "Please provide a zip in the format ######." );
      document.myForm.Zip.focus() ;
      return false;
    }
    if( document.myForm.Country.value == "-1" )
    {
      alert( "Please provide your country!" );
      return false;
    }
    return(true);
}











/*
 * var regex = /^[a-zA-Z]*$/;
    if (regex.test(x)) {
    	alert("First name must be only characters");
        return false;
    }
    
    
   
 */