import * as React from 'react';

interface Claim {
    id: string;
    name: string;
    amount: number;
}

interface ClaimListProps {
}

interface ClaimListState {
    claims: Array<Claim>;
    isLoading: boolean;
}

class ClaimList extends React.Component<ClaimListProps, ClaimListState> {

    constructor(props: ClaimListProps) {
        super(props);

        this.state = {
            claims: [],
            isLoading: false
        };
    }
    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/v1/claims/')
            .then(response => response.json())
            .then(data => this.setState({claims: data, isLoading: false}));
    }

    render() {
        const {claims, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Claims</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th className="right">Amount</th>
                    </tr>
                {claims.map((claim: Claim) =>
                    <tr key={claim.id}>
                        <td>{claim.name}</td>
                        <td className="right">{claim.amount}</td>
                    </tr>
                )}
                </table>
            </div>
        );
    }
}

export default ClaimList;
