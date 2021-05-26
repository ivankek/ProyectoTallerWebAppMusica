var audio = document.getElementById('player');
const queueMusic = document.querySelector('#queue');
const queue = document.querySelector('#playlist');


function queueShow(){
	if(queueMusic.className.includes("text-success")){
		queueMusic.classList.remove('text-success');
		queue.setAttribute('hidden', true);
	}else{
		queue.removeAttribute('hidden');
		queueMusic.classList.add('text-success');
	}
}