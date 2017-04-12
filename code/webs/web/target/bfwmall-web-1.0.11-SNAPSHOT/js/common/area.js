function showLocation(province , city , town,country,city_overseas) {
	
	var loc	= new Location();
	var loc_overseas	= new LocationOverseas();
	var title	= ['省份' , '地级市' , '市、县、区'];
	var title_overseas =['国家' , '城市'];
	$.each(title , function(k , v) {
		title[k]	= '<option value="">'+v+'</option>';
	})
	
	$.each(title_overseas , function(k , v) {
		title_overseas[k]	= '<option value="">'+v+'</option>';
	})
	
	$('#loc_province').append(title[0]);
	$('#loc_city').append(title[1]);
	$('#loc_town').append(title[2]);
	$("#loc_country").append(title_overseas[0]);
	$("#loc_city_overseas").append(title_overseas[1]);
	
	$('#loc_province').change(function() {
		$('#loc_city').empty();
		$('#loc_city').append(title[1]);
		loc.fillOption('loc_city' , '0,'+$('#loc_province').val());
		$('#loc_town').empty(); 
		$('#loc_town').append(title[2]);
		$('#province').val($(this).find(":selected").text()); //把选中的text值赋给隐藏框
	})
	
	$('#loc_city').change(function() {
		$('#loc_town').empty();
		$('#loc_town').append(title[2]);
		loc.fillOption('loc_town' , '0,' + $('#loc_province').val() + ',' + $('#loc_city').val());
		$('#city').val($(this).find(":selected").text()); //把选中的text值赋给隐藏框
	})
	
	$('#loc_town').change(function() {
		$('#town').val($(this).find(":selected").text()); //把选中的text值赋给隐藏框
	})
	
	$('#loc_country').change(function() {
		$('#loc_city_overseas').empty();
		$('#loc_city_overseas').append(title_overseas[1]);
		loc_overseas.fillOption('loc_city_overseas' , '0,'+$('#loc_country').val());
		$('#foreignCountry').val($(this).find(":selected").text()); //把选中的text值赋给隐藏框
	})
	
	$('#loc_city_overseas').change(function() {
		$('#overseasCity').val($(this).find(":selected").text()); //把选中的text值赋给隐藏框
	})
	
	if (province) {
		loc.fillOption('loc_province' , '0' , province);
		
		if (city) {
			loc.fillOption('loc_city' , '0,'+province , city);
			
			if (town) {
				loc.fillOption('loc_town' , '0,'+province+','+city , town);
			}
		}
		
	} else {
		loc.fillOption('loc_province' , '0');
	}
	
	if (country) {
		loc_overseas.fillOption('loc_country' , '0' , country);
		
		if (city_overseas) {
			loc_overseas.fillOption('loc_city_overseas' , '0,'+country , city_overseas);
		}
		
	} else {
		loc_overseas.fillOption('loc_country' , '0');
	}
		
}