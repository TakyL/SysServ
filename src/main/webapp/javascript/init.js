let listeinput = document.querySelectorAll("input");

function addlistener()
{
    filteredlisteinput();
}

/**
 * Attribue la date dans l'input
 * @param str : date en string au format dd-mm-yyyy
 */
function setDateInput(str)
{

    const [day, month, year] = str.split('/');

    const date = `${year}-${month}-${day}`;
    console.log(date);
    document.querySelector("input#date").value = date;
}

function fetchRowData(rowId) {
    // Create an array to store the row data
    const rowData = [];

    // Get the radio input element
    const radioInput = document.getElementById(`r${rowId}`);

    // Check if the radio input exists
    if (radioInput) {
        // Get the parent row element
        const row = radioInput.closest("tr");

        // Get all the cells in the row
        const cells = row.querySelectorAll("td");

        // Iterate over the cells and retrieve the data
        cells.forEach(cell => {
            const cellData = cell.textContent.trim();
            rowData.push(cellData);
        });
    }

    return rowData;
}
/**
 * Compare la listeinput de base avec celle une fois qui est load
 */
function filteredlisteinput() {
    // Once the document is loaded, compare the input elements
    window.addEventListener("DOMContentLoaded", (event) => {

        //Tableau des valeurs de la ligne
        let uniqueValues = [];

        // //Liste input lors du chargement
        // let elementA = Array.from(listeinput);
        //
        // //Liste input dom chargé (ajout des input du tableau)
        // let elementB = Array.from(document.querySelectorAll("input"));
        //
        // // Comparaison pour récupérer seulement les input tableau
        // elementA.forEach(element => {
        //     // Check if the element is not present in elementB
        //     if (!elementB.includes(element) && element.type=="radio") {
        //         uniqueValues.push(element);
        //     }
        // });
        //
        // // Iterate over elements in elementB
        // elementB.forEach(element => {
        //     // Check if the element is not present in elementA
        //     if (!elementA.includes(element)  && element.type=="radio") {
        //         uniqueValues.push(element);
        //     }
        // });

        console.log(uniqueValues);

        uniqueValues = document.querySelectorAll("input[type='radio']");

            //Action du radio bouton en fonction de la ligne
         uniqueValues.forEach(element => {
             element.addEventListener("click",(e)=>{

                 UpdateUI(element);
         })

         })
    });
}

/**
 * Maj les infos dans les input
 * @param element
 */
function setDataInputUpdate(element)
{
    let data = fetchRowData(element.id.substring(1));
    console.log(data);
    setDateInput(data[1]);
    document.querySelector("input#heurerdv").value = data[2]
    document.querySelector("input#client").value =data[3]
    document.querySelector("input#emp").value =data[4]
    document.querySelector("input[type='hidden']").value = element.id.substring(1)

}

/**
 * Maj à l'UI pour la mise à jour
 * @param element
 * @constructor
 */
function UpdateUI(element)
{
    document.querySelector("button").innerText="Modifier ce rdv";
    setDataInputUpdate(element);
    ClearRadioCheck(element);
}

/**
 * Désactive l'option checked si un autre radio button du tableau a été choisie afin d'en conserver un seul
 * @param element
 * @constructor
 */
function ClearRadioCheck(element)
{
    let listeradio = document.querySelectorAll("input[type='radio']");
    listeradio.forEach(radio =>
    {
        if(radio.id != element.id && radio.checked===true)
        {
            radio.checked=false;
        }
    })
}

/**
 * Rétablie Ajouter un Rdv après une modification d'un rdv
 */
function retablieajout()
{
    if(document.querySelector("input[type='hidden']").value != "null" )
    {
        document.querySelector("input[type='hidden']").value ==null;
        document.querySelector("button").innerText="Ajouter un rdv";
        let liste = document.querySelectorAll("input[type='radio']");
        liste.forEach(element=> {
            if(element.checked==true) element.checked=false;
        });

    }
}
addlistener();
retablieajout()
