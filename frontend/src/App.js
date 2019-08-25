import React, { Component } from 'react';
import axios from 'axios';
import MaterialTable from 'material-table'
import {number} from "prop-types";

class App extends Component {


    state = {
        persons: []
    }

    componentDidMount() {
        axios.get(`http://localhost:8081/toyota/faults`)
            .then(res => {
                const persons = res.data;
                this.setState({ persons });
            })

        axios.post(`http://localhost:8081/toyota/faults`)
            .then(res => {
                const persons = res.data;
                this.setState({ persons });
            })

        axios.delete(`http://localhost:8081/toyota/faults`)
            .then(res => {
                const persons = res.data;
                this.setState({ persons });
            })


    }

    render() {
        return (

            <MaterialTable
                columns={[
                    { title: 'Kayıt No', field: 'KAYIT_NO', type: number},
                    { title: 'Kayıt Tarihi', field: 'KAYIT_TARIHI'},
                    { title: 'Kayıt Yapan', field: 'KAYIT_YAPAN'},
                    { title: 'Bildiren', field: 'BILDIREN'},
                    { title: 'Bildiren Tel', field: 'BILDIREN_TEL'},
                    { title: 'Arıza', field: 'ARIZA'},
                    { title: 'Yeri', field: 'YERI'},
                    { title: 'Shop', field: 'SHOP'},
                    { title: 'Atanan', field: 'ATANAN'},
                    { title: 'Acil', field: 'ACIL'},
                    { title: 'İş Bitimi Açıklaması', field: 'IS_BITIMI_ACIKLAMA'},
                    { title: 'Tamamlama Tarihi', field: 'TAMAMLAMA_TARIHI'},

                ]}
                data = {
                    this.state.persons.map(person => {
                        return {
                            KAYIT_NO: person.id,
                            KAYIT_TARIHI: person.registerDate,
                            KAYIT_YAPAN: person.recorder,
                            BILDIREN: person.reporter,
                            BILDIREN_TEL: person.reporterTel,
                            ARIZA: person.faultType,
                            YERI: person.location,
                            SHOP: person.shop,
                            ATANAN: person.assigned,
                            ACIL: person.emergency,
                            IS_BITIMI_ACIKLAMA: person.explanation,
                            TAMAMLAMA_TARIHI: person.endDay,
                        }
                    })
                }
                title="TOYOTA ARIZA"
                options={{
                    filtering: true,
                    columnsButton: true,
                    paging: true,
                    showEmptyDataSourceMessage:true,
                }}
                editable={{

                    onRowAdd: newData =>
                        new Promise((resolve, reject) => {
                            setTimeout(() => {
                                {
                                    axios.post('http://localhost:8081/toyota/faults', ({
                                        reporter:newData.BILDIREN,
                                        registerDate:newData.KAYIT_TARIHI,
                                        recorder:newData.KAYIT_YAPAN,
                                        reporterTel:newData.BILDIREN_TEL,
                                        faultType:newData.ARIZA,
                                        location:newData.YERI,
                                        shop:newData.SHOP,
                                        assigned:newData.ATANAN,
                                        emergency:newData.ACIL,
                                        explanation:newData.IS_BITIMI_ACIKLAMA,
                                        endDay:newData.TAMAMLAMA_TARIHI,

                                    }));
                                }
                                resolve()
                            }, 1)
                        }),

                    onRowDelete: newData =>
                        new Promise((resolve, reject) => {
                            setTimeout(() => {
                                {
                                    axios.delete(`http://localhost:8081/toyota/faults/${newData.KAYIT_NO}`);
                                }
                                resolve()
                            }, 1)
                        }),
                }}
                localization={{
                    body: {
                        emptyDataSourceMessage: 'Kayıt Bulunamadı.',
                    },
                }}
            />
        );
    }}

export default App;