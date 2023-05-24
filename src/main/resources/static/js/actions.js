const publishButton = document.querySelector('#publishButton');
const unpublishButton = document.querySelector('#unpublishButton');

const disableButton = (button) => {
  button.disable = true;
};

publishButton.addEventListener('click', disableButton(unpublishButton));
unpublishButton.addEventListener('click', disableButton(publishButton));