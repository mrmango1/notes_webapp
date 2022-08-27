const getTables = async () => {
    const response = await fetch('./api/table');
    const data = await response.json();
    return data;
}

const writeTables = async () => {
    const data = await getTables();
    const tables = document.getElementById('response');
    tables.innerHTML = '';
    data.forEach(row => {
        const tr = document.createElement('div');
        tr.classList.add('card', 'text-bg-warning' ,'mb-3');
        tr.setAttribute('style', 'width: 18rem;');
        tr.innerHTML = `
        <div class="card-header">Header</div>
        <div class="card-body">
            <h5 class="card-title">${row.title}</h5>
            <p class="card-text">${row.description}</p>
            <div>
                <button class="btn btn-primary" onclick="editTable(${row.id_table})">Edit</button>
                <button class="btn btn-danger" onclick="deleteTable(${row.id_table})">Delete</button>
            </div>
        </div>
        `;
        tables.appendChild(tr);
    });
}
writeTables();